package com.desafio.unifiscal.services;

import java.util.Optional;

import com.desafio.unifiscal.services.dto.UserDTO;

public interface UserService {
	

	/**
     * save user.
     *
     * @param data transfer object of user.
     * @return UserDTO.
     */
	UserDTO save(UserDTO userDTO);
	
	
	/**
     * find one by user id .
     *
     * @param user id.
     * @return Optional<UserDTO>.
     */
	Optional<UserDTO> findOne(Long id);
	
	
	/**
     * find by user email .
     *
     * @param String email.
     * @return Optional<UserDTO>.
     */
	Optional<UserDTO> findByEmail(String email);
	
	
	

}
