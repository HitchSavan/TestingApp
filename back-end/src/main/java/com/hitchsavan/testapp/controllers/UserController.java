package com.hitchsavan.testapp.controllers;

import java.util.List;

import com.hitchsavan.testapp.models.User;
import com.hitchsavan.testapp.repository.UserRepository;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @PostMapping
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
}