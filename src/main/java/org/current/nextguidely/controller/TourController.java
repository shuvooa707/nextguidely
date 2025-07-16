package org.current.nextguidely.controller;

import org.current.nextguidely.persistence.entity.Tour;
import org.current.nextguidely.mapper.CityMapper;
import org.current.nextguidely.model.dto.CreateTourDTO;
import org.current.nextguidely.model.dto.TourDTO;
import org.current.nextguidely.model.dto.UpdateTourDTO;
import org.current.nextguidely.response.*;
import org.current.nextguidely.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tours")
public class TourController {
	
	@Autowired
	TourService tourService;
	@Autowired
	private CityMapper cityMapper;
	
	
	// Get all users
	@GetMapping
	public ResponseEntity<GetToursResponse> index(@RequestParam(name = "page", defaultValue = "0") Integer page, @RequestParam(name = "size", defaultValue = "10") Integer size) {
		List<TourDTO> tourDTOS = tourService.getAllTours(page, size);
		GetToursResponse getToursResponse = GetToursResponse.getResponse("success", tourDTOS, page, size);
		return ResponseEntity.ok(getToursResponse);
	}
	
	/// Create a Tour
	@PostMapping
	public ResponseEntity<Map<String, Object>> create(@RequestBody CreateTourDTO createTourDTO) {
		Tour tourDTO = tourService.createTour(createTourDTO, 1L);
		if (tourDTO == null) {
			return ResponseEntity.ok( Map.of("message", "success") );
		}
		System.out.println(tourDTO);
		return ResponseEntity.ok( Map.of(
				"message", "success"
		));
	}
	
	
	@PutMapping({"/{id}"})
	public ResponseEntity<UpdateTourResponse> create(@PathVariable Long id, @RequestBody UpdateTourDTO updateTourDTO) {
		TourDTO tourDTO = tourService.updateTour(id, updateTourDTO);
		return ResponseEntity.ok(UpdateTourResponse.getResponse("success", tourDTO));
	}
	
	// Update user
//	@PutMapping("/{id}")
//	public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDto) {
//		return ResponseEntity.ok(cityService.updateCity(id, userDto));
//	}
//

	// Delete user
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> deleteUser(@PathVariable Long id) {
		tourService.deleteTour(id);
		return ResponseEntity.ok(Map.of("message", "success"));
	}
}
