package com.brendon.Java.RESTful.API.Santander.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.brendon.Java.RESTful.API.Santander.service.UserService;
import com.brendon.Java.RESTful.API.Santander.domain.model.User;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private User userToCreated;

    public UserController(UserService  userService) {
        this.userService = userService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> findById(User userToCreated) {
        this.userToCreated = userToCreated;
        var userCreated = userService.findById(userToCreated.getId());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.ok(userToCreated);
    }
}
