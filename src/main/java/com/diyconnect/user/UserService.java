package com.diyconnect.user;

import java.util.List;
import java.util.Optional;

public interface UserService {
    <S extends User> S save(S entity);

    <S extends User> Iterable<S> saveAll(Iterable<S> entities);

    Optional<User> findById(Long aLong);

    Optional<List<User>> findByCityName(String cityName);

    Optional<User> findByEmail(String email);

    boolean existsById(Long aLong);

    List<User> findAll();

    Iterable<User> findAllById(Iterable<Long> longs);

    long count();

    void deleteById(Long aLong);

    void delete(User entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends User> entities);

    void deleteAll();

    void activateUser(String token);

    Optional<User> modifyCity(String cityName, String userEmail);

    Optional<User> findByUsername(String username);
}
