package com.diyconnect.band;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BandRepository extends CrudRepository<Band, Long> {

    Optional<List<Band>> findByCityName(String cityName);
}
