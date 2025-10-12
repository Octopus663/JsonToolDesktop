package com.example.jsontooldesktop.service;

import com.example.jsontooldesktop.model.User;
import com.example.jsontooldesktop.repository.UserRepository;
import com.example.jsontooldesktop.repository.UserRepositoryImpl;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public User register(String username, String password) throws IllegalArgumentException {

        if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Користувач з таким іменем вже існує!");
        }

        String hashedPassword = password;

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(hashedPassword);

        userRepository.save(newUser);
        return newUser;
    }

    @Override
    public Optional<User> login(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(password)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}