package com.desafio.unifiscal.services;

import java.math.BigDecimal;
import java.util.Optional;

import com.desafio.unifiscal.services.dto.InvoiceDTO;

public interface InvoiceService {
	
	/**
     * save invoice.
     *
     * @param data transfer object of invoices.
     * @return InvoiceDTO.
     */
	InvoiceDTO save(InvoiceDTO invoiceDTO);
	
	
	/**
     * findOne by invoice id .
     *
     * @param invoice id.
     * @return Optional<InvoiceDTO>.
     */
	Optional<InvoiceDTO> findOne(Long id);
	
	
	/**
     * delete by invoice id.
     *
     * @param invoice id.
     * @return void.
     */
	void delete(Long id);
	
	
	/**
     * update invoice.
     *
     * @param data transfer object of invoices.
     * @return InvoiceDTO.
     */
	InvoiceDTO update(InvoiceDTO invoiceDTO);
	
	
	
	
	
}
