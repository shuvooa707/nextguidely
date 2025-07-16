package org.current.nextguidely.mapper;

import org.current.nextguidely.model.dto.LanguageDTO;
import org.current.nextguidely.persistence.entity.Language;
import org.springframework.stereotype.Component;

@Component
public class LanguageMapper {
    
    public LanguageDTO toDTO(Language language) {
        if (language == null) return null;
        
        LanguageDTO dto = new LanguageDTO();
        dto.setId(language.getId());
        dto.setName(language.getName());
        return dto;
    }
    
    public Language toEntity(LanguageDTO languageDTO) {
        if (languageDTO == null) return null;
        
        Language language = new Language();
        language.setId(languageDTO.getId());
        language.setName(languageDTO.getName());
        return language;
    }
}
