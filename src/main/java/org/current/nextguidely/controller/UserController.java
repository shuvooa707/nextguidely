package org.current.nextguidely.controller;

import org.current.nextguidely.model.dto.UpdateUserLanguageDTO;
import org.current.nextguidely.model.dto.CreateUserDTO;
import org.current.nextguidely.persistence.entity.User;
import org.current.nextguidely.mapper.UserMapper;
import org.current.nextguidely.response.GetUserResponse;
import org.current.nextguidely.response.GetUsersResponse;
import org.current.nextguidely.response.UpdateUserLangugeResponse;
import org.current.nextguidely.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	private UserMapper userMapper;
	
	
	// Get all users
	@GetMapping
	public ResponseEntity<GetUsersResponse> getAllUsers(@RequestParam(name = "page", defaultValue = "0") Integer page, @RequestParam(name = "size", defaultValue = "10") Integer size) {
		List<CreateUserDTO> allUsers = userService.getAllUsers(page, size);
		GetUsersResponse response = GetUsersResponse.getResponse("success", allUsers, page, size);
		return ResponseEntity.ok(response);
	}
	
	// Get user by ID
	@GetMapping("/{id}")
	public ResponseEntity<GetUserResponse> getUserById(@PathVariable Long id) {
		CreateUserDTO createUserDTO = userMapper.toDto(userService.getUserById(id));
		if (createUserDTO == null) {
			return ResponseEntity.ok(GetUserResponse.getResponse("failed", null));
		}
		return ResponseEntity.ok(GetUserResponse.getResponse("success", createUserDTO));
	}
	
	// Update user
	@PutMapping("/{id}")
	public ResponseEntity<CreateUserDTO> updateUser(@PathVariable Long id, @RequestBody CreateUserDTO createUserDto) {
		return ResponseEntity.ok(userService.updateUser(id, createUserDto));
	}
	
	// Delete user
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity
			       .noContent()
			       .build();
	}
	
	
	@PutMapping("/{id}/update-languages")
	public ResponseEntity<UpdateUserLangugeResponse> updateUser(@PathVariable(name = "id") Long id, @RequestBody UpdateUserLanguageDTO updateUserLanguageDTO) {
		User user = userService.updateUserLanguageById(id, updateUserLanguageDTO);
		CreateUserDTO createUserDTO = userMapper.toDto(user);
		if (createUserDTO == null) {
			return ResponseEntity.ok(UpdateUserLangugeResponse.getResponse("failed", null));
		}
		
		return ResponseEntity.ok(UpdateUserLangugeResponse.getResponse("success", createUserDTO));
	}
}
