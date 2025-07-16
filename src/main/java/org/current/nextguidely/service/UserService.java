package org.current.nextguidely.service;


import org.current.nextguidely.model.dto.RegisterUserDTO;
import org.current.nextguidely.model.dto.UpdateUserLanguageDTO;
import org.current.nextguidely.model.dto.CreateUserDTO;
import org.current.nextguidely.persistence.entity.City;
import org.current.nextguidely.persistence.entity.Language;
import org.current.nextguidely.persistence.entity.User;
import org.current.nextguidely.mapper.UserMapper;
import org.current.nextguidely.persistence.repository.CityRepository;
import org.current.nextguidely.persistence.repository.LanguageRepository;
import org.current.nextguidely.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    LanguageRepository languageRepository;
    
    @Autowired
    UserMapper userMapper;
    
    
    public CreateUserDTO createUser(RegisterUserDTO registerUserDTO) {
        if (userRepository.existsByEmail(registerUserDTO.getEmail())) {
            throw new IllegalArgumentException("Email already in use.");
        }
        if (!cityRepository.existsById(registerUserDTO.getCityId())) {
            throw new IllegalArgumentException("City not valid.");
        }
        
        
        System.out.println("|-----cityId------|");
        System.out.println(registerUserDTO.getCityId());
        System.out.println("|-----originCityId------|");
        System.out.println(registerUserDTO.getOriginCityId());
        
        City currentCity = cityRepository
                                   .findById(registerUserDTO.getCityId())
                                   .get();
        
        City originCity = null;
        if (Objects.equals(registerUserDTO.getOriginCityId(), registerUserDTO.getCityId())) {
            originCity = currentCity;
        }
        
        System.out.println("----------------------------------------------------");
        System.out.println("----------------------------------------------------");
        System.out.println("----------------------------------------------------");
        System.out.println("----------------------------------------------------");
        System.out.println("----------------------------------------------------");
        System.out.println("----------------------------------------------------");
        
        
        User user = new User();
        user.setEmail(registerUserDTO.getEmail());
        user.setDob(registerUserDTO.getDob());
        user.setGender(registerUserDTO.getGender());
        user.setName(registerUserDTO.getName());
        user.setThumbnail(registerUserDTO.getThumbnail());
        user.setDescription(registerUserDTO.getDescription());
        user.setMoto(registerUserDTO.getMoto());
        user.setAbout(registerUserDTO.getAbout());
        user.setPassword(registerUserDTO.getPassword());
        user.setCurrentCity(currentCity);
        user.setOriginCity(originCity);
        
        
        List<Long> languageIds = Arrays
                                         .stream(registerUserDTO.getLanguageIds())
                                         .mapToLong(Long::valueOf)
                                         .boxed()
                                         .toList();
        
        List<Language> languages = languageRepository.findAllById(languageIds);
        user.setLanguages(languages);
        
        
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }
    
    public List<CreateUserDTO> getAllUsers(Integer page, Integer size) {
        return userRepository
                       .findAll(PageRequest.of(page, size))
                       .stream()
                       .map(userMapper::toDto)
                       .collect(Collectors.toList());
    }
    
    public User getUserById(Long id) {
        User user = userRepository
                            .findById(id)
                            .orElseGet(() -> null);
        
        if (user == null) {
            return null;
        }
        return user;
    }
    
    public CreateUserDTO updateUser(Long id, CreateUserDTO CreateUserDTO) {
        User existingUser = userRepository.findById(id)
                                          .orElseThrow(
                                                  () -> new IllegalArgumentException("User not found with id: " + id));
        
        existingUser.setName(CreateUserDTO.getName());
        existingUser.setEmail(CreateUserDTO.getEmail());
        existingUser.setRole(CreateUserDTO.getRole());
        
        User updatedUser = userRepository.save(existingUser);
        return userMapper.toDto(updatedUser);
    }
    
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
    
    public User updateUserLanguageById(Long id, UpdateUserLanguageDTO updateUserLanguageDTO) {
        User user = getUserById(id);
        List<Language> languages = languageRepository.findAllById(List.of(updateUserLanguageDTO.getLanguageIds()));
        System.out.println(languages);
        user.setLanguages(languages);
        userRepository.save(user);
        
        return user;
    }
}
