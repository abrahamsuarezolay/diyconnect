package com.diyconnect.band;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BandRepository extends CrudRepository<Band, Long> {

}
