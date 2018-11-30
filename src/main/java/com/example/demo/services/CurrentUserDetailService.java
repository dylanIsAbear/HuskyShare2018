package com.example.demo.services;

import com.example.demo.Entity.CurrentUser;
import com.example.demo.Entity.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.logging.Logger;

public class CurrentUserDetailService implements UserDetailsService {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CurrentUserDetailService.class);
    private final UserService  userService;

    @Autowired
    public CurrentUserDetailService(UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        LOGGER.info(("Authenticating user with email={}", email.replaceFirst("@.*", "@***"));
        User user = userService.getUserByEmail(email);
        return (UserDetails) new CurrentUser(user);
    }
}
