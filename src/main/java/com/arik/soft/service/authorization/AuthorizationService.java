package com.arik.soft.service.authorization;

public interface AuthorizationService {

    String generateHashedPassword(String password);

    boolean login(String userName, String password);
}
