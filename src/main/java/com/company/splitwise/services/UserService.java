package com.company.splitwise.services;

import com.company.splitwise.dtos.CreateUserDTO;
import com.company.splitwise.dtos.UserDTO;
import com.company.splitwise.models.User;
import com.company.splitwise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    UserRepository userRepository;

    public UserDTO createUser(CreateUserDTO userRequest) {

        //Encode Plain text Password
        String hashedPassword = passwordEncoder.encode(userRequest.getPassword());

        //Converted DTO to User -> by creating one static method in User class.
        User user = User.from(userRequest,hashedPassword);

        // Persist the user
        User persistedUser = userRepository.save(user);

        return UserDTO.from(persistedUser);

    }

    public Optional<User> getUser(Long userId) {
        return userRepository.findById(userId);
    }
}
