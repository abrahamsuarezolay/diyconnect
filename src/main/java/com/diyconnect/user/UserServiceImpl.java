package com.diyconnect.user;

import com.diyconnect.city.City;
import com.diyconnect.city.CityRepository;
import com.diyconnect.exception.cityException.CityNotFoundException;
import com.diyconnect.exception.userException.NoUsersForCityException;
import com.diyconnect.exception.userException.UserAlreadyExistsException;
import com.diyconnect.exception.userException.UserNotFoundException;
import com.diyconnect.role.Role;
import com.diyconnect.role.RoleRepository;
import com.diyconnect.userRole.UserRole;
import com.diyconnect.userRole.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public <S extends User> S save(S entity) {

        try {
            //For now, we just save new users on the user role
            Role role = roleRepository.findByName("ROLE_USER").get();

            //We declare the userRole instance
            UserRole userRole = new UserRole(entity, role);

            //We add to the user entity the userRole instance and we encrypt the password
            entity.setUserRoles(new ArrayList<UserRole>());
            entity.getUserRoles().add(userRole);
            entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));

            //We save both tables
            userRepository.save(entity);
            userRoleRepository.save(userRole);

            return entity;
        } catch (DataIntegrityViolationException e) {
            throw new UserAlreadyExistsException();
        }
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

        if (users.isEmpty()) {
            throw new NoUsersForCityException();
        } else {
            return users;
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {

        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()) {
            throw new UserNotFoundException();
        } else {
            return userRepository.findByEmail(email);
        }
    }

    public Optional<User> modifyCity(String cityName, String userEmail) {

        City cityToAdd = cityRepository.findByName(cityName).get();
        User userToModify = userRepository.findByEmail(userEmail).get();

        userToModify.setCity(cityToAdd);

        userRepository.save(userToModify);
        return Optional.of(userToModify);
    }

}
