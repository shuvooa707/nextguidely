package org.current.nextguidely.persistence.repository;

import org.current.nextguidely.persistence.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
}
