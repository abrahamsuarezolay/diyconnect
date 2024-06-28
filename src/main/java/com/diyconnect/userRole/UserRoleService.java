package com.diyconnect.userRole;

import java.util.Optional;

public interface UserRoleService {
    <S extends UserRole> S save(S entity);

    <S extends UserRole> Iterable<S> saveAll(Iterable<S> entities);

    Optional<UserRole> findById(Long aLong);

    boolean existsById(Long aLong);

    Iterable<UserRole> findAll();

    Iterable<UserRole> findAllById(Iterable<Long> longs);

    long count();

    void deleteById(Long aLong);

    void delete(UserRole entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends UserRole> entities);

    void deleteAll();
}
