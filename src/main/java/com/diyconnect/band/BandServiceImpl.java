package com.diyconnect.band;

import com.diyconnect.exception.bandException.NoBandForCityException;
import com.diyconnect.exception.bandException.NoBandForUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BandServiceImpl implements BandService {
    @Autowired
    private BandRepository bandRepository;

    @Override
    public <S extends Band> S save(S entity) {
        return bandRepository.save(entity);
    }

    @Override
    public <S extends Band> Iterable<S> saveAll(Iterable<S> entities) {
        return bandRepository.saveAll(entities);
    }

    @Override
    public Optional<Band> findById(Long aLong) {
        return bandRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return bandRepository.existsById(aLong);
    }

    @Override
    public Iterable<Band> findAll() {
        return bandRepository.findAll();
    }

    @Override
    public Iterable<Band> findAllById(Iterable<Long> longs) {
        return bandRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return bandRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        bandRepository.deleteById(aLong);
    }

    @Override
    public void delete(Band entity) {
        bandRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        bandRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Band> entities) {
        bandRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        bandRepository.deleteAll();
    }

    public Optional<List<Band>> findByCityName(String cityName) {
        Optional<List<Band>> band = bandRepository.findByCityName(cityName);

        if(band.isEmpty()) {
            throw new NoBandForCityException();
        }else{
            return band;
        }
    }

    public Optional<List<Band>> findByUserEmail(String userEmail) {
        Optional<List<Band>> bands = bandRepository.findByUserEmail(userEmail);

        if(bands.isEmpty()){
            throw new NoBandForUserException();
        }else{
            return bands;
        }
    }
}
