package com.minibus.moment.domain.emoticon;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmoticonRepository extends JpaRepository<Emoticon, Integer> {
    Optional<Emoticon> findByNameEquals(String emoticonName);
}
