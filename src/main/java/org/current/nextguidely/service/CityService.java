package org.current.nextguidely.service;

import org.current.nextguidely.model.dto.CityDTO;
import org.current.nextguidely.model.dto.CreateCityDTO;
import org.current.nextguidely.persistence.entity.City;
import org.current.nextguidely.persistence.entity.Country;
import org.current.nextguidely.mapper.CityMapper;
import org.current.nextguidely.persistence.repository.CityRepository;
import org.current.nextguidely.persistence.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {
	
	@Autowired
	CityRepository cityRepository;
	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	private CityMapper cityMapper;


	public CityDTO createCity(String cityName, Country country) {
		if (cityRepository.existsByName(cityName)) {
			throw new IllegalArgumentException("City already exists with this name.");
		}

		if ( country == null ) {
			throw new IllegalArgumentException("Country Does Not Exist.");
		}
		City newcity = new City();
		newcity.setName(cityName);
		newcity.setCountry(country);


		City savedCity = cityRepository.save(newcity);
		return cityMapper.toDTO(savedCity);
	}

	public CityDTO createCity(CreateCityDTO cityDTO) {
		if (cityRepository.existsByName(cityDTO.getName())) {
			throw new IllegalArgumentException("City already exists with this name.");
		}
		Country country = countryRepository
				.findById(cityDTO.getCountryId())
				.get();

		if ( country == null ) {
			throw new IllegalArgumentException("Country Does Not Exist.");
		}
		City newcity = new City();
		newcity.setName(cityDTO.getName());
		newcity.setCountry(country);


		City savedCity = cityRepository.save(newcity);
		return cityMapper.toDTO(savedCity);
	}
	
	public List<CityDTO> getAllCities(Integer page, Integer size) {
		return cityRepository
			       .findAll(PageRequest.of(page, size))
			       .stream()
			       .map(cityMapper::toDTO)
			       .collect(Collectors.toList());
	}
	
	public CityDTO getCityById(Long id) {
		return cityRepository
			       .findById(id)
			       .map(cityMapper::toDTO)
			       .orElse(null);
	}
	
	public CityDTO updateCity(Long id, CityDTO cityDTO) {
		City existingCity = cityRepository.findById(id)
		                                  .orElseThrow(() -> new IllegalArgumentException("City not found with id: " + id));
		
		existingCity.setName(cityDTO.getName());
		existingCity.setCountry(cityDTO.getCountry());
		
		City updatedCity = cityRepository.save(existingCity);
		return cityMapper.toDTO(updatedCity);
	}
	
	public void deleteCity(Long id) {
		if (!cityRepository.existsById(id)) {
			throw new IllegalArgumentException("City not found with id: " + id);
		}
		cityRepository.deleteById(id);
	}
}
