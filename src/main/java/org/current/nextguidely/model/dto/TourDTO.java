package org.current.nextguidely.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.current.nextguidely.persistence.entity.City;
import org.current.nextguidely.persistence.entity.User;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourDTO {
    Long id;
    Date from;
    Date to;
    Integer members = 1;
    String description;
    Date createdAt;
    Date updatedAt;
    User user;
    List<City> cities;
}
