package org.current.nextguidely.service;

import org.current.nextguidely.model.dto.LanguageDTO;
import org.current.nextguidely.persistence.entity.Language;
import org.current.nextguidely.mapper.LanguageMapper;
import org.current.nextguidely.persistence.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Autowired
	private LanguageMapper languageMapper;


	public LanguageDTO createLanguage(String languageName) {
		if (languageRepository.existsByName(languageName)) {
			throw new IllegalArgumentException("language already exists with this name.");
		}
		Language newLanguage = new Language();
		newLanguage.setName(languageName);
		
		
		newLanguage = languageRepository.save(newLanguage);
		return languageMapper.toDTO(newLanguage);
	}
}
