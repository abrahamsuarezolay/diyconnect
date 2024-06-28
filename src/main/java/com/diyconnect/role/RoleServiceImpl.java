package com.diyconnect.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public <S extends Role> S save(S entity) {
        return roleRepository.save(entity);
    }

    @Override
    public <S extends Role> Iterable<S> saveAll(Iterable<S> entities) {
        return roleRepository.saveAll(entities);
    }

    @Override
    public Optional<Role> findById(Long aLong) {
        return roleRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return roleRepository.existsById(aLong);
    }

    @Override
    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Iterable<Role> findAllById(Iterable<Long> longs) {
        return roleRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return roleRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        roleRepository.deleteById(aLong);
    }

    @Override
    public void delete(Role entity) {
        roleRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        roleRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Role> entities) {
        roleRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        roleRepository.deleteAll();
    }
}
