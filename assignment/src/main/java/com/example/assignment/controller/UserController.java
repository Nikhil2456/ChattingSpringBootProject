package com.example.assignment.controller;

import com.example.assignment.dto.UserDto;
import com.example.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    @Autowired
    private UserService userService;

    //API to get User by name
    @PostMapping("/user/{name}")
    public UserDto save(@PathVariable("name") String name) {
        return userService.createUserByName(name);
    }
}
