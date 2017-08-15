package com.arik.soft.service;

import com.arik.soft.domain.User;
import com.arik.soft.domain.UserRepository;
import com.arik.soft.service.authorization.AuthorizationService;
import com.arik.soft.service.representation.UserRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {


    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorizationService authorizationService;

    @Override
    @Transactional(readOnly = true)
    public List<UserRepresentation> getUserDetails() {
        return StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .map(UserRepresentation::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserRepresentation saveUser(UserRepresentation userData) {
        final String password = authorizationService.generateHashedPassword(userData.getPassword());

        userData.setPassword(password);
        return new UserRepresentation(
                userRepository.save(UserRepresentation.getUser(userData))
        );
    }

    @Override
    @Transactional(readOnly = true)
    public UserRepresentation getUserById(Long userId) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findOne(userId));
        return userOptional.map(UserRepresentation::new)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Unable to find user by id %d", userId)));
    }

    @Override
    @Transactional
    public void deleteUserById(Long userId) {
        userRepository.delete(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public UserRepresentation getUserByUserName(String userName) {
        return userRepository
                .findByUserName(userName)
                .map(UserRepresentation::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
