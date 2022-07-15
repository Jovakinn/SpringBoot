package com.example.secureuserservice.service;

import com.example.secureuserservice.domain.Role;
import com.example.secureuserservice.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    // not for production use
    List<User> getUsers();
}
