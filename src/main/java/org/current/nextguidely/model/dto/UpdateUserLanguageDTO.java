package org.current.nextguidely.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateUserLanguageDTO {
	private Long[] languageIds;
}
