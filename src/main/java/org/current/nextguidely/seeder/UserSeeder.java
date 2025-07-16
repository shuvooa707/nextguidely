package org.current.nextguidely.seeder;

import com.github.javafaker.Faker;
import org.current.nextguidely.model.dto.RegisterUserDTO;
import org.current.nextguidely.persistence.entity.Gender;
import org.current.nextguidely.service.CityService;
import org.current.nextguidely.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.stream.IntStream;

@Component
public class UserSeeder
{

    @Autowired
    private UserService userService;
    @Autowired
    private CityService cityService;


    public void run() {
        

        long[] cityIds = cityService
                .getAllCities(0, 1000000)
                .stream()
                .map(city -> city.getId())
                .mapToLong(Long::longValue)
                .toArray();
        
        
        
        if (cityIds.length > 0) {
            IntStream
                    .range(0, 3)
                    .forEach(i -> {
                        Faker faker = new Faker();
                        String firstName = faker.name().firstName();
                        String lastName = faker.name().lastName();
                        String email = faker.internet().emailAddress();
                        String password = faker.internet().password();
                        Gender gender = faker.number().numberBetween(0, 2) == 1 ? Gender.MALE : Gender.FEMALE;
                        Date birthDate = faker.date().between(new Date(), new Date(1947, 01, 01));
                        Long cityId = cityIds[(int)(Math.random() * cityIds.length)];
                        
                        RegisterUserDTO registerUserDTO = new RegisterUserDTO();
                        registerUserDTO.setName(firstName + " " + lastName);
                        registerUserDTO.setEmail(email);
                        registerUserDTO.setGender(gender);
                        registerUserDTO.setDob(birthDate);
                        registerUserDTO.setPassword(password);
                        registerUserDTO.setCityId(cityId);
                        
//                        System.out.println( registerUserDTO );
                        try {
                            var u = userService.createUser(registerUserDTO);
                            
                        } catch (Exception e) {

                        }
                    });
        }
    }
}
