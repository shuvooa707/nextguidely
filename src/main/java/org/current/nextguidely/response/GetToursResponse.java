package org.current.nextguidely.response;

import org.current.nextguidely.model.dto.TourDTO;

import java.util.List;

public class GetToursResponse extends Response {
	public String message;
	public Object data = null;
	GetToursResponse(String message, List<TourDTO> tourDTOS, Integer p, Integer ps) {
		this.message = message;
		this.data = new Object() {
			public List<TourDTO> tours = tourDTOS;
			public Integer total = tourDTOS.size();
			public Integer page = p;
			public Integer page_size = ps;
		};
	}

	public static GetToursResponse getResponse(String message, List<TourDTO> tourDTOS, Integer p, Integer ps) {
		return new GetToursResponse(message, tourDTOS, p, ps);
	}
}
