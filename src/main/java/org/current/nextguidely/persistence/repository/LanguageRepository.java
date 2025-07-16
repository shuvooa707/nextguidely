package org.current.nextguidely.persistence.repository;

import org.current.nextguidely.persistence.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
    boolean existsByName(String languageName);
}
