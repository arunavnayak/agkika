package com.arik.soft.service;

import com.arik.soft.domain.User;
import com.arik.soft.domain.UserDetailsImpl;
import com.arik.soft.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class JpaBasedUserDetailService implements UserDetailsService {


    private static final Logger LOGGER = LoggerFactory.getLogger(JpaBasedUserDetailService.class);

    private UserRepository userRepository;

    public JpaBasedUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUserName(userName);
        return userOptional
                .map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException("User name not found"));
    }
}
