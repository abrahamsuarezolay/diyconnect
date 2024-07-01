package com.diyconnect.band;

import java.util.List;
import java.util.Optional;

public interface BandService {
    <S extends Band> S save(S entity);

    <S extends Band> Iterable<S> saveAll(Iterable<S> entities);

    Optional<Band> findById(Long aLong);

    boolean existsById(Long aLong);

    Iterable<Band> findAll();

    Iterable<Band> findAllById(Iterable<Long> longs);

    long count();

    void deleteById(Long aLong);

    void delete(Band entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends Band> entities);

    void deleteAll();

    Optional<List<Band>> findByCityName(String cityName);
}
