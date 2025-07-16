package org.current.nextguidely.response;

import org.current.nextguidely.model.dto.TourDTO;

public class UpdateTourResponse extends Response {
	public String message;
	public Object data = null;
	UpdateTourResponse(String message, TourDTO tourDTO) {
		this.message = message;
		this.data = new Object() {
			public TourDTO tour = tourDTO;
		};
	}

	public static UpdateTourResponse getResponse(String message, TourDTO tourDTO) {
		return new UpdateTourResponse(message, tourDTO);
	}
}
