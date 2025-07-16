package org.current.nextguidely.response;


import lombok.Data;

@Data
public class RegisterSuccessResponse extends Response {
	public RegisterSuccessResponse(String message, Object data) {
		this.message = message;
		this.data = data;
	}

	public static RegisterSuccessResponse getInstance(String message, String t) {
		return new RegisterSuccessResponse(message, new Object(){
			public String token = t;
		});
	}
}
