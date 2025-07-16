package org.current.nextguidely.persistence.repository;

import org.current.nextguidely.persistence.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	boolean existsByName(String name);
	
	List<City> findByCountryId(Long countryId);
}
