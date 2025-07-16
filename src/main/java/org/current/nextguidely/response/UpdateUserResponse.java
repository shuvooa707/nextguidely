package org.current.nextguidely.response;

import org.current.nextguidely.model.dto.CreateUserDTO;

public class UpdateUserResponse extends Response {
	public String message;
	public Object data = null;
	UpdateUserResponse(String message, CreateUserDTO createUserDto) {
		this.message = message;
		this.data = new Object() {
			public CreateUserDTO user = createUserDto;
		};
	}

	public static UpdateUserResponse getResponse(String message, CreateUserDTO user) {
		return new UpdateUserResponse(message, user);
	}
}
