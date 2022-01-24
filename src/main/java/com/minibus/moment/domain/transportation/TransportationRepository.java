package com.minibus.moment.domain.transportation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransportationRepository extends JpaRepository<Transportation, Integer> {
    Optional<Transportation> findByNameEquals(String name);
}
