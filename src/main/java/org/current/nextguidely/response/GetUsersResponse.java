package org.current.nextguidely.response;

import org.current.nextguidely.model.dto.CreateUserDTO;

import java.util.List;

public class GetUsersResponse extends Response {
	public String message;
	public Object data = null;
	GetUsersResponse(String message, List<CreateUserDTO> createUserDtos, Integer p, Integer ps) {
		this.message = message;
		this.data = new Object() {
			public List<CreateUserDTO> users = createUserDtos;
			public Integer total = createUserDtos.size();
			public Integer page = p;
			public Integer page_size = ps;
		};
	}

	public static GetUsersResponse getResponse(String message, List<CreateUserDTO> allUsers, Integer p, Integer ps) {
		return new GetUsersResponse(message, allUsers, p, ps);
	}
}
