package com.desafio.unifiscal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.unifiscal.domain.Tax;

public interface TaxRepository extends JpaRepository<Tax, Long> {

}
