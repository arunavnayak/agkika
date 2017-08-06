package com.arik.soft.config.authorization;

import com.arik.soft.config.persistance.RepositoryConfig;
import com.arik.soft.domain.UserRepository;
import com.arik.soft.service.JpaBasedUserDetailService;
import com.arik.soft.service.authorization.AuthorizationService;
import com.arik.soft.service.authorization.AuthorizationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(RepositoryConfig.class)
public class AuthorizationConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public AuthorizationService getAuthorizationService() {
        AuthorizationServiceImpl authorizationService = new AuthorizationServiceImpl();
        authorizationService.setUserRepository(userRepository);
        return authorizationService;
    }

    @Bean
    public JpaBasedUserDetailService jpaBasedUserDetailService() {
        return new JpaBasedUserDetailService(userRepository);
    }


}
