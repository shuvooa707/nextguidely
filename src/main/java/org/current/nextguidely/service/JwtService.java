package org.current.nextguidely.service;

import org.current.nextguidely.model.dto.CreateUserDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class JwtService {
	public String generateToken(CreateUserDTO createUserDto) {
		return UUID.randomUUID().toString();
	}
}
