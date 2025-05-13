package com.gaming.gaminglegensbackend.repositories;

import com.gaming.gaminglegensbackend.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
    User findByUsername(String username);
    User findByEmail(String email);
}
