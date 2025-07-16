package org.current.nextguidely.controller;

import org.current.nextguidely.model.dto.CityDTO;
import org.current.nextguidely.model.dto.CreateCityDTO;
import org.current.nextguidely.mapper.CityMapper;
import org.current.nextguidely.response.*;
import org.current.nextguidely.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {
	
	@Autowired
	CityService cityService;
	@Autowired
	private CityMapper cityMapper;
	
	
	// Get all users
	@GetMapping
	public ResponseEntity<GetCitiesResponse> index(@RequestParam(name = "page", defaultValue = "0") Integer page, @RequestParam(name = "size", defaultValue = "10") Integer size) {
		List<CityDTO> cities = cityService.getAllCities(page, size);
		GetCitiesResponse getCitiesResponse = GetCitiesResponse.getResponse("success", cities, page, size);
		return ResponseEntity.ok(getCitiesResponse);
	}
	
	// Get user by ID
	@GetMapping("/{id}")
	public ResponseEntity<GetCityResponse> getUserById(@PathVariable Long id) {
		CityDTO city = cityService.getCityById(id);
		if (city == null) {
			return ResponseEntity.ok( GetCityResponse.getResponse("failed", null) );
		}
		return ResponseEntity.ok( GetCityResponse.getResponse("success", cityService.getCityById(id) ) );
	}
	
	
	@PostMapping
	public ResponseEntity<CreateCityResponse> create(@RequestBody CreateCityDTO createCityDTO) {
		CityDTO city = cityService.createCity(createCityDTO);
		return ResponseEntity.ok(CreateCityResponse.getResponse("success", city));
	}
	
	// Update user
//	@PutMapping("/{id}")
//	public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDto) {
//		return ResponseEntity.ok(cityService.updateCity(id, userDto));
//	}
//
//	// Delete user
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//		userService.deleteUser(id);
//		return ResponseEntity
//			       .noContent()
//			       .build();
//	}
}
