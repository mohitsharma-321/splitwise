package com.company.splitwise.controllers;

import com.company.splitwise.dtos.CreateUserDTO;
import com.company.splitwise.dtos.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @PostMapping("/user")
    private UserDTO createUser(CreateUserDTO userRequest){

    }
}

// Create User => HTTP Verb-> POST , Endpoint -> /api/v1/user
