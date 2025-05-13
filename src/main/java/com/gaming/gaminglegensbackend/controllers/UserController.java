package com.gaming.gaminglegensbackend.controllers;


import com.gaming.gaminglegensbackend.entities.User;
import com.gaming.gaminglegensbackend.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.service.RequestBodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@Tag(name = "User API", description = "Operations related to users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RequestBodyService requestBodyService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public  boolean login (@RequestBody Map<String,String> RequestBody){
        String username=RequestBody.get("username");
        String password=RequestBody.get("password");
        return userService.login(username,password);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }


}
