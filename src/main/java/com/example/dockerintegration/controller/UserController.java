package com.example.dockerintegration.controller;

import com.example.dockerintegration.entity.User;
import com.example.dockerintegration.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@Slf4j
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        log.info("START - GET api/v1/user");
        var response = userService.getAllUsers();
        log.info("END - GET api/v1/user");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getUserById(
            @PathVariable(name = "id") String userId
    ) {
        log.info("START - GET api/v1/user/{}", userId);
        var response = userService.getUserById(userId);
        log.info("END - GET api/v1/user/{}", userId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<?> saveUser(
            @RequestBody User user
    ) {
        log.info("START - POST api/v1/user");
        var response = userService.saveUser(user);
        log.info("END - POST api/v1/user");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
