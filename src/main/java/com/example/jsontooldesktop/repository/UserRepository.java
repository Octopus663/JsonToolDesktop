package com.example.jsontooldesktop.repository;

import com.example.jsontooldesktop.model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
    List<User> findAll();
    void delete(User user);
}