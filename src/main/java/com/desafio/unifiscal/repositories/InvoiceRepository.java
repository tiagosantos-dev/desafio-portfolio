package com.desafio.unifiscal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.unifiscal.domain.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
