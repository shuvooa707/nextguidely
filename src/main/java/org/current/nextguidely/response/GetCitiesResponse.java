package org.current.nextguidely.response;

import org.current.nextguidely.model.dto.CityDTO;

import java.util.List;

public class GetCitiesResponse extends Response {
	public String message;
	public Object data = null;
	GetCitiesResponse(String message, List<CityDTO> cityDTOS, Integer p, Integer ps) {
		this.message = message;
		this.data = new Object() {
			public List<CityDTO> cities = cityDTOS;
			public Integer total = cityDTOS.size();
			public Integer page = p;
			public Integer page_size = ps;
		};
	}

	public static GetCitiesResponse getResponse(String message, List<CityDTO> cities, Integer p, Integer ps) {
		return new GetCitiesResponse(message, cities, p, ps);
	}
}
