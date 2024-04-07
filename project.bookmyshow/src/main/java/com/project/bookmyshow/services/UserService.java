package com.project.bookmyshow.services;

import com.project.bookmyshow.models.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(int userId);
}
