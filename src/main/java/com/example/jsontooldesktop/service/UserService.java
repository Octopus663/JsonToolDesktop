package com.example.jsontooldesktop.service;

import com.example.jsontooldesktop.model.User;
import java.util.Optional;

public interface UserService {

    User register(String username, String password) throws IllegalArgumentException;
    Optional<User> login(String username, String password);
}