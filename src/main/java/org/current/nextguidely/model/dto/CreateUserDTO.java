package org.current.nextguidely.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.current.nextguidely.persistence.entity.Gender;
import org.current.nextguidely.persistence.entity.Language;
import org.current.nextguidely.persistence.entity.Role;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {
	Long id;
	String name;
	String thumbnail;
	Date dob;
	String email;
	Gender gender;
	List<Language> languages;
	Role role = Role.USER;
}
