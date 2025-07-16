package org.current.nextguidely.seeder;

import com.github.javafaker.Faker;
import org.current.nextguidely.service.CityService;
import org.current.nextguidely.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class CitySeeder
{

    @Autowired
    private CityService cityService;

    public void run() {
    }
}
