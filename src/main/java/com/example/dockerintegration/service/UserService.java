package com.example.dockerintegration.service;

import com.example.dockerintegration.entity.User;

import java.util.List;

public interface UserService {

    User getUserById(String id);
    User saveUser(User user);
    List<User> getAllUsers();
}
