package com.desafio.unifiscal.services.impl;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.desafio.unifiscal.domain.Invoice;
import com.desafio.unifiscal.domain.Tax;
import com.desafio.unifiscal.domain.enums.TypeOfTaxes;
import com.desafio.unifiscal.repositories.InvoiceRepository;
import com.desafio.unifiscal.repositories.TaxRepository;
import com.desafio.unifiscal.services.InvoiceService;
import com.desafio.unifiscal.services.dto.InvoiceDTO;
import com.desafio.unifiscal.services.exceptions.EntityNotFoundException;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	
	@Override
	public InvoiceDTO save(InvoiceDTO invoiceDTO) {
		if(invoiceDTO == null) {
			 throw new EntityNotFoundException("invoice undefined");
		}else {
			  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			formatter.format(invoiceDTO.getDateOfIssuance());
			 Tax taxCOFINS = new Tax(TypeOfTaxes.COFINS, "Contribuição para o Financiamento da Seguridade Social", 15.20, invoiceDTO.getTotal());
			Tax taxPIS = new Tax(TypeOfTaxes.PIS, "Programas de Integração Social e de Formação do Patrimônio do Servidor Público", 1.65, invoiceDTO.getTotal());
			Tax taxIRPJ = new Tax(TypeOfTaxes.IRPJ, "Imposto de Renda de Pessoa Jurídica", 15, invoiceDTO.getTotal());
			Tax taxCSLL  = new Tax(TypeOfTaxes.CSLL, "Contribuição Social sobre o Lucro Líquido", 9, invoiceDTO.getTotal());
			Tax taxICMS  = new Tax(TypeOfTaxes.ICMS, " Operações relativas à Circulação de Mercadorias e sobre Prestações de Serviços de Transporte Interestadual e Intermunicipal e de Comunicação", 18, invoiceDTO.getTotal());
			Tax taxISS  = new Tax(TypeOfTaxes.ISS, "Imposto Sobre Serviços", 2,invoiceDTO.getTotal());
			
			invoiceDTO.setTaxes(Arrays.asList(taxCOFINS,taxPIS, taxIRPJ, taxCSLL, taxICMS, taxISS));
			
			Invoice invoice = this.invoiceRepository.save(new Invoice(invoiceDTO));
			
			
			return new InvoiceDTO(invoice);
		}
		
	}

	@Override
	public Optional<InvoiceDTO> findOne(Long id) {
		if(id == null || id == 0) {
			throw new EntityNotFoundException("Id not found"+ id);
		}else {
			return this.invoiceRepository.findById(id).map(InvoiceDTO::new);
			
		}
		
		
		
	}

	@Override
	public void delete(Long id) {
		this.invoiceRepository.deleteById(id);
		
	}

	@Override
	public InvoiceDTO update(InvoiceDTO invoiceDTO) {
		if(invoiceDTO.getId() == null) {
			throw new EntityNotFoundException("Id not found"+ invoiceDTO.getId());
		}else {
			Invoice invoice = this.invoiceRepository.findById(invoiceDTO.getId()).get();
			
			invoiceDTO.setId(invoice.getId());
			
			Invoice invoiceReceivd = this.invoiceRepository.save(new Invoice(invoiceDTO));
			return new InvoiceDTO(invoiceReceivd);
		}
		
	}

	@Override
	public List<InvoiceDTO> findAll(Integer pageSize , Integer size) {
		Pageable paging = PageRequest.of(pageSize, size);
		Page<Invoice> page = this.invoiceRepository.findAll(paging);
		
		return page.toList().stream().map(InvoiceDTO::new).collect(Collectors.toList());
	}

}
