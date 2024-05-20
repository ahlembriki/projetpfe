package project.security;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import project.models.UserEntity;
import project.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CustomUserDetailsService  {

    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }






}
