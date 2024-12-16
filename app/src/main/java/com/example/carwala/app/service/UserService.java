package com.example.carwala.app.service;

import com.example.carwala.app.entity.User;

import java.util.Optional;

public interface UserService {

    User createUser(User user);
    Optional<User> getUserById(Long id);
    Optional<User> getUserByUsername(String username);
    boolean isUsernameExists(String username);
    boolean isEmailExist(String email);
}
