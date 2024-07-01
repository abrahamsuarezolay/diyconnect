package com.diyconnect.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<List<User>> findByCityName(String cityName);

    Optional<User> findByEmail(String email);

}
