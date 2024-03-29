package com.example.dockerintegration.service;

import com.example.dockerintegration.entity.User;
import com.example.dockerintegration.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(String id) {
        User user = null;
        try {
            user = userRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException ex) {
            log.error("User with id {} does not exist", id);
        }
            return user;
    }

    @Override
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        log.info("Saved user {}", savedUser.getUsername());
        return savedUser;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
