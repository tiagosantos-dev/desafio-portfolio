package com.desafio.unifiscal.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.unifiscal.controllers.requests.InvoicePostRequest;
import com.desafio.unifiscal.controllers.requests.InvoicePutRequest;
import com.desafio.unifiscal.services.InvoiceService;
import com.desafio.unifiscal.services.dto.InvoiceDTO;

@RestController
@RequestMapping("api")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	
	
	@GetMapping("/invoices/{pageSize}/{size}")
	public ResponseEntity<List<InvoiceDTO>> findAll(@PathVariable Integer pageSize, 
            @PathVariable Integer size) {
		List<InvoiceDTO> list = this.invoiceService.findAll(pageSize, size);
		
		if(list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			
			for(InvoiceDTO invoice: list) {
				long id = invoice.getId();
				invoice.add(linkTo(methodOn(InvoiceController.class).findById(id)).withSelfRel());
				
			}
		}
		return ResponseEntity.ok(list);
		
	}
	
	@PostMapping("invoices")
	public ResponseEntity<InvoiceDTO> save(@Valid @RequestBody InvoicePostRequest dto) {
		InvoiceDTO invoiceDTOReceid = this.invoiceService.save(new InvoiceDTO(dto));
		invoiceDTOReceid.add(linkTo(methodOn(InvoiceController.class).findById(invoiceDTOReceid.getId())).withSelfRel());
		return ResponseEntity.created(URI.create("api/invoices/"+invoiceDTOReceid.getId())).body(invoiceDTOReceid);
	}
	
	@GetMapping("invoices/{id}")
	public ResponseEntity<InvoiceDTO> findById(@PathVariable(value="id")final Long id) {
		Optional<InvoiceDTO> invoicesOptional =  this.invoiceService.findOne(id);
		
		if(!invoicesOptional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
				
			invoicesOptional.get().add(linkTo(methodOn(InvoiceController.class).findAll(0, 10)).withRel("listOfInvoices") );
			return ResponseEntity.ok(invoicesOptional.get());
		}
		
	}
	
	@PutMapping("invoices")
	public ResponseEntity<InvoiceDTO> update(@Valid @RequestBody InvoicePutRequest dto) {
		
		InvoiceDTO invoiceDTOReceived = this.invoiceService.update(new InvoiceDTO(dto));
		
		if(invoiceDTOReceived == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}else {
			invoiceDTOReceived.add(linkTo(methodOn(InvoiceController.class).findById(invoiceDTOReceived.getId())).withSelfRel());
			return ResponseEntity.ok(invoiceDTOReceived);
			
		}
		
		
	}
	
	@DeleteMapping("invoices/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		this.invoiceService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	
}
