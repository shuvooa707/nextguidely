package org.current.nextguidely.response;

import org.current.nextguidely.model.dto.CreateUserDTO;

public class UpdateUserLangugeResponse extends Response {
	public String message;
	public Object data = null;
	UpdateUserLangugeResponse(String message, CreateUserDTO createUserDto) {
		this.message = message;
		this.data = new Object() {
			public CreateUserDTO user = createUserDto;
		};
	}

	public static UpdateUserLangugeResponse getResponse(String message, CreateUserDTO user) {
		return new UpdateUserLangugeResponse(message, user);
	}
}
