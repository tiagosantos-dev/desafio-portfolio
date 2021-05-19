package com.desafio.unifiscal.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.unifiscal.domain.Invoice;
import com.desafio.unifiscal.repositories.InvoiceRepository;
import com.desafio.unifiscal.services.InvoiceService;
import com.desafio.unifiscal.services.dto.InvoiceDTO;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	
	@Override
	public InvoiceDTO save(InvoiceDTO invoiceDTO) {
		if(invoiceDTO == null) {
			 throw new RuntimeException("");
		}else {
			Invoice invoice = this.invoiceRepository.save(new Invoice(invoiceDTO));
			return new InvoiceDTO(invoice);
		}
		
	}

	@Override
	public Optional<InvoiceDTO> findOne(Long id) {
		return this.invoiceRepository.findById(id).map(InvoiceDTO::new);
	}

	@Override
	public void delete(Long id) {
		this.invoiceRepository.deleteById(id);
		
	}

	@Override
	public InvoiceDTO update(InvoiceDTO invoiceDTO) {
		if(invoiceDTO.getId() == null) {
			throw new RuntimeException("Occoreu um erro");
		}else {
			Invoice invoice = this.invoiceRepository.findById(invoiceDTO.getId()).get();
			
			invoiceDTO.setId(invoice.getId());
			
			Invoice invoiceReceivd = this.invoiceRepository.save(new Invoice(invoiceDTO));
			return new InvoiceDTO(invoiceReceivd);
		}
		
	
	}

}
