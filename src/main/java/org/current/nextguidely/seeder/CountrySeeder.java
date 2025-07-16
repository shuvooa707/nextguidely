package org.current.nextguidely.seeder;

import com.github.javafaker.Faker;
import org.current.nextguidely.persistence.entity.Country;
import org.current.nextguidely.service.CityService;
import org.current.nextguidely.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class CountrySeeder {
    
    @Autowired
    private CountryService countryService;
    @Autowired
    private CityService cityService;
    
    public void run() {
        
        IntStream
                .range(0, 100)
                .forEach(i -> {
                    Faker faker = new Faker();
                    String countryName = faker.address()
                                              .country();
                    String cityName = faker.address()
                                           .city();
                    try {
                        Country country = countryService.createCountry(countryName);
                        cityService.createCity(cityName, country);
                    } catch (Exception e) {
                    
                    }
                });
    }
}
