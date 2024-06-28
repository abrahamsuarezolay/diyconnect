package com.diyconnect.role;

import java.util.Optional;

public interface RoleService {
    <S extends Role> S save(S entity);

    <S extends Role> Iterable<S> saveAll(Iterable<S> entities);

    Optional<Role> findById(Long aLong);

    boolean existsById(Long aLong);

    Iterable<Role> findAll();

    Iterable<Role> findAllById(Iterable<Long> longs);

    long count();

    void deleteById(Long aLong);

    void delete(Role entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends Role> entities);

    void deleteAll();
}
