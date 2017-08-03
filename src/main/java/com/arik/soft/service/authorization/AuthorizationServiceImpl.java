package com.arik.soft.service.authorization;

import com.arik.soft.domain.User;
import com.arik.soft.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AuthorizationServiceImpl implements AuthorizationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationServiceImpl.class);

    private static final String SALT = "eastuser";

    private UserRepository userRepository;

    @Override
    public String generateHashedPassword(String password) {
        String saltedPassword = SALT + password;
        return generateHash(saltedPassword);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean login(String userName, String password) {
        Boolean isAuthenticated = false;

        String hashedPassword = generateHashedPassword(password);

        User user = userRepository.findByUserName(userName).get();
        if (user != null) {
            String storedPasswordHash = user.getPassword();
            if (hashedPassword.equals(storedPasswordHash)) {
                isAuthenticated = true;
            } else {
                isAuthenticated = false;
            }
        }

        return isAuthenticated;
    }

    private String generateHash(String input) {
        StringBuilder hash = new StringBuilder();

        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] hashedBytes = sha.digest(input.getBytes());
            char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                    'a', 'b', 'c', 'd', 'e', 'f'};
            for (int idx = 0; idx < hashedBytes.length; ++idx) {
                byte b = hashedBytes[idx];
                hash.append(digits[(b & 0xf0) >> 4]);
                hash.append(digits[b & 0x0f]);
            }
        } catch (NoSuchAlgorithmException e) {
        }

        return hash.toString();
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
