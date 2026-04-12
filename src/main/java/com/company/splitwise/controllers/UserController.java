package com.company.splitwise.controllers;

import com.company.splitwise.dtos.CreateUserDTO;
import com.company.splitwise.dtos.ResponseDTO;
import com.company.splitwise.dtos.UserDTO;
import com.company.splitwise.models.User;
import com.company.splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired                  // better way is constructor injection
    UserService userService;

    @PostMapping("/user")
    private UserDTO createUser(@RequestBody CreateUserDTO userRequest){
        return userService.createUser(userRequest);

    }


    @GetMapping("/user/{userId}")
    private ResponseDTO<UserDTO> getUser(@PathVariable Long userId) {
        Optional<User> user = userService.getUser(userId);
        Optional<UserDTO> userDTO = user.map(UserDTO::from);// using method reference with Optional class feature, Can also be done by lamda expression
        return userDTO.map(ResponseDTO::success).orElse(ResponseDTO.notFound());
    }
}

// Create User => HTTP Verb-> POST , Endpoint -> /api/v1/user
// Fetch User => HTTP Verb -> GET , Endpoint  -> /api/v1/user/:userId
