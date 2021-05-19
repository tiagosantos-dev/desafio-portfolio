package com.desafio.unifiscal.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.desafio.unifiscal.services.UserService;
import com.desafio.unifiscal.services.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public UserDTO save(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UserDTO> findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UserDTO> findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
