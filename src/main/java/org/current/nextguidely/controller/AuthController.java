package org.current.nextguidely.controller;

import org.current.nextguidely.model.dto.RegisterUserDTO;
import org.current.nextguidely.model.dto.CreateUserDTO;
import org.current.nextguidely.mapper.UserMapper;
import org.current.nextguidely.response.RegisterSuccessResponse;
import org.current.nextguidely.service.JwtService;
import org.current.nextguidely.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	UserService userService;

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private JwtService jwtService;

	// Create a new user
	@PostMapping({"/register", "register"})
	public ResponseEntity<RegisterSuccessResponse> register(@RequestBody RegisterUserDTO registerUserDTO) {
		CreateUserDTO createdUser = userService.createUser(registerUserDTO);
		String token = jwtService.generateToken(createdUser);
		return ResponseEntity.ok(RegisterSuccessResponse.getInstance("success", token));
	}
	@PostMapping("/login")
	public ResponseEntity<CreateUserDTO> login(@RequestBody RegisterUserDTO registerUserDTO) {
		CreateUserDTO createdUser = userService.createUser(registerUserDTO);
		return ResponseEntity.status(201).body(createdUser);
	}
	@PostMapping("/reset-password")
	public ResponseEntity<CreateUserDTO> resetPassword(@RequestBody RegisterUserDTO registerUserDTO) {
		CreateUserDTO createdUser = userService.createUser(registerUserDTO);
		return ResponseEntity.status(201).body(createdUser);
	}
}
