package org.current.nextguidely.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.current.nextguidely.persistence.entity.Gender;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDTO {
	Long id;
	String name;
	Date dob;
	String email;
	Gender gender;
	Long cityId;
	Long originCityId;
	Integer[] languageIds;
	String description = "";
	String moto = "";
	String about = "";
	String thumbnail = "john-avatar.png";
	String password;
}
