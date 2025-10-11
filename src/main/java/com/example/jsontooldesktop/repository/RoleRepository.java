package com.example.jsontooldesktop.repository;

import com.example.jsontooldesktop.model.Role;
import java.util.Optional;

public interface RoleRepository {
    void save(Role role);
    Optional<Role> findByName(String name);
}