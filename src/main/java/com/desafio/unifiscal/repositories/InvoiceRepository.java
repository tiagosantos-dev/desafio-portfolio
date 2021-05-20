package com.desafio.unifiscal.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.desafio.unifiscal.domain.Invoice;
import com.desafio.unifiscal.services.dto.InvoiceDTO;

@Repository
public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Long> {
	
}
