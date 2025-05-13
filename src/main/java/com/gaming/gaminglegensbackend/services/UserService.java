package com.gaming.gaminglegensbackend.services;


import com.gaming.gaminglegensbackend.entities.User;
import com.gaming.gaminglegensbackend.repositories.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User getUserById(int id) {
        return (User) userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public boolean login(String username, String password) {
        User user=this.userRepository.findByUsername(username);
        if(user !=null){
            return true ;
        }
        return false;
    }

    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable((User) userRepository.findByUsername(username));
    }
}
