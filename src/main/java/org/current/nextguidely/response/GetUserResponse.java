package org.current.nextguidely.response;

import org.current.nextguidely.model.dto.CreateUserDTO;

public class GetUserResponse extends Response {
	public String message;
	public Object data = null;
	GetUserResponse(String message, CreateUserDTO createUserDto) {
		this.message = message;
		this.data = new Object() {
			public CreateUserDTO user = createUserDto;
		};
	}

	public static GetUserResponse getResponse(String message, CreateUserDTO user) {
		return new GetUserResponse(message, user);
	}
}
