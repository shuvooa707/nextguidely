package org.current.nextguidely.response;

import org.current.nextguidely.model.dto.CityDTO;

public class GetCityResponse extends Response {
	public String message;
	public Object data = null;
	GetCityResponse(String message, CityDTO cityDTO) {
		this.message = message;
		this.data = new Object() {
			public CityDTO city = cityDTO;
		};
	}

	public static GetCityResponse getResponse(String message, CityDTO city) {
		return new GetCityResponse(message, city);
	}
}
