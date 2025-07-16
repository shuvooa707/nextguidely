package org.current.nextguidely.mapper;

import org.current.nextguidely.model.dto.CreateUserDTO;
import org.current.nextguidely.persistence.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
	@Value("${SITE_ROOT_URL}")
	String SITE_ROOT_URL;

	public CreateUserDTO toDto(User user) {
		if (user == null) return null;

		CreateUserDTO dto = new CreateUserDTO();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setThumbnail(SITE_ROOT_URL + "/" + user.getThumbnail());
		dto.setEmail(user.getEmail());
		dto.setDob(user.getDob());
		dto.setGender(user.getGender());
		dto.setRole(user.getRole());
		dto.setLanguages(user.getLanguages());
		
		return dto;
	}

	public User toEntity(CreateUserDTO dto) {
		if (dto == null) return null;

		User user = new User();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setDob(dto.getDob());
		user.setGender(dto.getGender());

		return user;
	}
}

