package org.current.nextguidely.mapper;

import org.current.nextguidely.model.dto.CityDTO;
import org.current.nextguidely.persistence.entity.City;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {
	
	public CityDTO toDTO(City city) {
		if (city == null) return null;
		
		CityDTO dto = new CityDTO();
		dto.setId(city.getId());
		dto.setName(city.getName());
		dto.setCountry(city.getCountry());
		return dto;
	}
	
	public City toEntity(CityDTO cityDTO) {
		if (cityDTO == null) return null;
		
		City city = new City();
		city.setId(cityDTO.getId());
		city.setName(cityDTO.getName());
		city.setCountry(cityDTO.getCountry());
		return city;
	}
}