package org.current.nextguidely.mapper;


import org.current.nextguidely.model.dto.TourDTO;
import org.current.nextguidely.persistence.entity.Tour;
import org.springframework.stereotype.Component;

@Component
public class TourMapper {

    public TourDTO toDTO(Tour tour) {
        if (tour == null) return null;

        TourDTO dto = new TourDTO();
        dto.setId(tour.getId());
        dto.setMembers(tour.getMembers());
        dto.setDescription(tour.getDescription());
        dto.setFrom(tour.getStartsAt());
        dto.setTo(tour.getEndsAt());
        dto.setUser(tour.getUser());
//        dto.setCities(tour.getCities());
        dto.setCreatedAt(tour.getCreatedAt());
        dto.setUpdatedAt(tour.getUpdatedAt());

        return dto;
    }

    public Tour toEntity(TourDTO tourDTO) {
        if (tourDTO == null) return null;

        Tour tour = new Tour();
        tour.setId(tourDTO.getId());
        tour.setMembers(tourDTO.getMembers());
        tour.setDescription(tourDTO.getDescription());
        tour.setStartsAt(tourDTO.getFrom());
        tour.setEndsAt(tourDTO.getTo());
        tour.setUser(tourDTO.getUser());
        tour.setCities(tourDTO.getCities());
        tour.setCreatedAt(tourDTO.getCreatedAt());
        tour.setUpdatedAt(tourDTO.getUpdatedAt());

        return tour;
    }
}