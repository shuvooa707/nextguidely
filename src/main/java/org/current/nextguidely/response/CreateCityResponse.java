package org.current.nextguidely.response;

import org.current.nextguidely.model.dto.CityDTO;

public class CreateCityResponse extends Response {
	public String message;
	public Object data = null;
	CreateCityResponse(String message, CityDTO cityDTO) {
		this.message = message;
		this.data = new Object() {
			public CityDTO city = cityDTO;
		};
	}

	public static CreateCityResponse getResponse(String message, CityDTO city) {
		return new CreateCityResponse(message, city);
	}
}
