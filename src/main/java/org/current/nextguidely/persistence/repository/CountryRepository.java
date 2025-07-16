package org.current.nextguidely.persistence.repository;

import org.current.nextguidely.persistence.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
}
