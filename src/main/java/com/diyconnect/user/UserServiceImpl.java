package com.diyconnect.user;

import com.diyconnect.city.City;
import com.diyconnect.city.CityRepository;
import com.diyconnect.exception.cityException.CityNotFoundException;
import com.diyconnect.exception.userException.NoUsersForCityException;
import com.diyconnect.exception.userException.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public <S extends User> S save(S entity) {
        return userRepository.save(entity);
    }

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
        return userRepository.saveAll(entities);
    }

    @Override
    public Optional<User> findById(Long aLong) {
        return userRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return userRepository.existsById(aLong);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Iterable<User> findAllById(Iterable<Long> longs) {
        return userRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        userRepository.deleteById(aLong);
    }

    @Override
    public void delete(User entity) {
        userRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        userRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {
        userRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public Optional<List<User>> findByCityName(String cityName) {

        Optional<List<User>> users = userRepository.findByCityName(cityName);

        if(users.isEmpty()){
            throw new NoUsersForCityException();
        }else{
            return users;
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {

        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()){
            throw new UserNotFoundException();
        }else{
            return userRepository.findByEmail(email);
        }
    }
}
