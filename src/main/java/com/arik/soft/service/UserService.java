package com.arik.soft.service;

import com.arik.soft.service.representation.UserRepresentation;

import java.util.List;

public interface UserService {
    List<UserRepresentation> getUserDetails();

    UserRepresentation saveUser(UserRepresentation userData);

    UserRepresentation getUserById(Long userId);

    void deleteUserById(Long userId);

    UserRepresentation getUserByUserName(String userName);
}
