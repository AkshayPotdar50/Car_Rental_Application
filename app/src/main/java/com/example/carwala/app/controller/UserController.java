package com.example.carwala.app.controller;

import com.example.carwala.app.entity.User;
import com.example.carwala.app.service.UserService;
import com.example.carwala.app.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;


    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser=userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Optional<User>> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.of(Optional.ofNullable(userService.getUserByUsername(username)));
    }

    @GetMapping("/exists/username/{username}")
    public ResponseEntity<Boolean> isUsernameExists(@PathVariable String username) {
        return ResponseEntity.ok(userService.isUsernameExists(username));
    }

    @GetMapping("/exists/email/{email}")
    public ResponseEntity<Boolean> isEmailExists(@PathVariable String email) {
        return ResponseEntity.ok(userService.isEmailExist(email));
    }
}
