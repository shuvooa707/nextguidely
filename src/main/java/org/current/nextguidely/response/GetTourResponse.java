package org.current.nextguidely.response;

import org.current.nextguidely.model.dto.TourDTO;

public class GetTourResponse {
    public String message;
    public Object data = null;
    GetTourResponse(String message, TourDTO tourDTO) {
        this.message = message;
        this.data = new Object() {
            public TourDTO tour = tourDTO;
        };
    }

    public static GetTourResponse getResponse(String message, TourDTO tourDTO) {
        return new GetTourResponse(message, tourDTO);
    }
}
