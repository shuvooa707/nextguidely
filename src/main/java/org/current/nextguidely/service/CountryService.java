package org.current.nextguidely.service;

import org.current.nextguidely.persistence.entity.Country;
import org.current.nextguidely.persistence.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;


    public Country createCountry(String countryName) {
        Country newCountry = new Country();
        newCountry.setName(countryName);

        countryRepository.save(newCountry);
        return newCountry;
    }
}
