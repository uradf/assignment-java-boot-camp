package com.example.ecommerce.controller;

import com.example.ecommerce.entity.UserInput;
import com.example.ecommerce.response.UserDetailResponse;
import com.example.ecommerce.response.UserResponse;
import com.example.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
public class UserController {

    final String API = "/api/v1";

    @Autowired
    UserService userService;

    @PostMapping(API + "/auth")
    public UserResponse auth(@RequestBody UserInput userInput) throws NoSuchAlgorithmException {
        return new UserResponse("/auth", userService.getToken(userInput.getUserId(), userInput.getPassword()));
    }

    @GetMapping(API + "/getAddress")
    public UserDetailResponse userDetail(@RequestHeader("e-com") String token) {
        return new UserDetailResponse("/getAddress", userService.getUserDetail(token));
    }
}
