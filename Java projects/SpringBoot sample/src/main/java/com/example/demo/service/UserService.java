package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends BaseService<User, UserRepository> {

    private User user;

    public User login(String username, String password) {
        Optional<User> userOptional = repository.findByUsername(username);

        if (userOptional.isPresent() && userOptional.get().getPassword().equals(password)) {
            user = userOptional.get();
            return user;
        }
        return null;
    }
}