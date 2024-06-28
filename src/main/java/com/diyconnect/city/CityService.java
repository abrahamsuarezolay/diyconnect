package com.diyconnect.city;

import java.util.Optional;

public interface CityService {
    <S extends City> S save(S entity);

    <S extends City> Iterable<S> saveAll(Iterable<S> entities);

    Optional<City> findById(Long aLong);

    boolean existsById(Long aLong);

    Iterable<City> findAll();

    Iterable<City> findAllById(Iterable<Long> longs);

    long count();

    void deleteById(Long aLong);

    void delete(City entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends City> entities);

    void deleteAll();

    Optional<City> findByName(String name);
}
