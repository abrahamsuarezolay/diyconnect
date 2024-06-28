package com.diyconnect.userRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public <S extends UserRole> S save(S entity) {
        return userRoleRepository.save(entity);
    }

    @Override
    public <S extends UserRole> Iterable<S> saveAll(Iterable<S> entities) {
        return userRoleRepository.saveAll(entities);
    }

    @Override
    public Optional<UserRole> findById(Long aLong) {
        return userRoleRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return userRoleRepository.existsById(aLong);
    }

    @Override
    public Iterable<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public Iterable<UserRole> findAllById(Iterable<Long> longs) {
        return userRoleRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return userRoleRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        userRoleRepository.deleteById(aLong);
    }

    @Override
    public void delete(UserRole entity) {
        userRoleRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        userRoleRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends UserRole> entities) {
        userRoleRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        userRoleRepository.deleteAll();
    }
}
