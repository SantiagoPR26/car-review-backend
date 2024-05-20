package dev.uni.infrastructure.api.controller;

import dev.uni.application.UserApplication;
import dev.uni.domain.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserApplication userApplication;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userApplication.saveUser(user), HttpStatus.CREATED);
    }
}
