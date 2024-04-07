package com.project.bookmyshow.services;

import com.project.bookmyshow.models.User;
import com.project.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findById(int userId) {
        return userRepository.findById(userId);

    }
}
