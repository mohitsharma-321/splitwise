package com.company.splitwise.services;

import com.company.splitwise.dtos.CreateUserDTO;
import com.company.splitwise.dtos.UserDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserDTO createUser(CreateUserDTO userRequest) {
        String hashedPassword = passwordEncoder.encode(userRequest.getPassword());
        return null;
    }
}
