package com.company.splitwise.controllers;

import com.company.splitwise.dtos.CreateUserDTO;
import com.company.splitwise.dtos.UserDTO;
import com.company.splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired                  // better way is constructor injection
    UserService userService;

    @PostMapping("/user")
    private UserDTO createUser(CreateUserDTO userRequest){
        return userService.createUser(userRequest);
    }
}

// Create User => HTTP Verb-> POST , Endpoint -> /api/v1/user
