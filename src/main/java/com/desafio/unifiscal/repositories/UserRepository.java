package com.desafio.unifiscal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.unifiscal.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
