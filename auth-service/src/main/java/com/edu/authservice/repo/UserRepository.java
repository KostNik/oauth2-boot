package com.edu.authservice.repo;

import com.edu.authservice.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findUserByUsername(String username);

}
