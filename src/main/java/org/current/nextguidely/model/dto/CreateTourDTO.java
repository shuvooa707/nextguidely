package org.current.nextguidely.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTourDTO {
    Long id;
    Date from;
    Date to;
    Integer members = 1;
    String description;
    Date createdAt;
    Date updatedAt;
    Long userId;
    Long[] cityIds;
}
