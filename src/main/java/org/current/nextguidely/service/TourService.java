package org.current.nextguidely.service;

import org.current.nextguidely.model.dto.CreateTourDTO;
import org.current.nextguidely.model.dto.TourDTO;
import org.current.nextguidely.model.dto.UpdateTourDTO;
import org.current.nextguidely.persistence.entity.City;
import org.current.nextguidely.persistence.entity.Tour;
import org.current.nextguidely.persistence.entity.User;
import org.current.nextguidely.mapper.TourMapper;
import org.current.nextguidely.mapper.UserMapper;
import org.current.nextguidely.persistence.repository.CityRepository;
import org.current.nextguidely.persistence.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TourService {
    @Autowired
    TourRepository tourRepository;
    @Autowired
    private TourMapper tourMapper;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    public Tour createTour(CreateTourDTO createTourDTO, Long userId) {
        User user = userService.getUserById(userId);
        Tour tour = new Tour();
        List<City> cities = cityRepository.findAllById(Arrays.asList(createTourDTO.getCityIds()));


        System.out.println("-------------------------------------");
        System.out.println(createTourDTO.getCityIds()[0]);

        tour.setUser(user);
        tour.setStartsAt(createTourDTO.getTo());
        tour.setEndsAt(createTourDTO.getFrom());
        tour.setDescription(createTourDTO.getDescription());
        tour.setCities(cities);
        tour.setMembers(createTourDTO.getMembers());
        tourRepository.save(tour);

        return tour;
    }

    public List<TourDTO> getAllTours(Integer page, Integer size) {
        return tourRepository
                .findAll(PageRequest.of(page, size))
                .stream()
                .map(tourMapper::toDTO)
                .toList();
    }

    public TourDTO getTourById(Long id) {
        Tour tour = tourRepository
                .findById(id)
                .get();

        return tourMapper.toDTO(tour);
    }

    public TourDTO updateTour(Long tourId, UpdateTourDTO updateTourDTO) {
        Tour tour = tourRepository
                .findById(tourId)
                .orElseThrow(() -> {
                    throw new NoSuchElementException("No value present");
                });

        tour.setMembers(updateTourDTO.getMembers());
        tour.setDescription(updateTourDTO.getDescription());
        tour.setStartsAt(updateTourDTO.getFrom());
        tour.setEndsAt(updateTourDTO.getTo());


        tourRepository.save(tour);
        return null;
    }

    public void deleteTour(Long id) {
        Tour tour = tourRepository
                        .findById(id)
                        .orElseThrow();

        tourRepository.delete(tour);
    }
}
