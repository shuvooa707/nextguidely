package org.current.nextguidely.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.current.nextguidely.persistence.entity.Country;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {
	public Long id;
	public String name;
	public Country country;
}
