package com.diyconnect.city;

import com.diyconnect.exception.cityException.CityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public <S extends City> S save(S entity) {
        return cityRepository.save(entity);
    }

    @Override
    public <S extends City> Iterable<S> saveAll(Iterable<S> entities) {
        return cityRepository.saveAll(entities);
    }

    @Override
    public Optional<City> findById(Long aLong) {
        return cityRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return cityRepository.existsById(aLong);
    }

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Iterable<City> findAllById(Iterable<Long> longs) {
        return cityRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return cityRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        cityRepository.deleteById(aLong);
    }

    @Override
    public void delete(City entity) {
        cityRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        cityRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends City> entities) {
        cityRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        cityRepository.deleteAll();
    }

    @Override
    public Optional<City> findByName(String name) {

        Optional<City> city = cityRepository.findByName(name);

        if (city.isEmpty()){
            throw new CityNotFoundException();
        }else{
            return city;
        }


    }
}
