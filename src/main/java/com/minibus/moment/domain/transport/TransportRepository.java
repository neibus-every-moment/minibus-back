package com.minibus.moment.domain.transport;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransportRepository extends JpaRepository<Transport, Integer> {

    Optional<Transport> findByName(String transportName);
}
