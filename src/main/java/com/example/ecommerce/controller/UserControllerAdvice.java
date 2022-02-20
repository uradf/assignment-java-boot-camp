package com.example.ecommerce.controller;

import com.example.ecommerce.exception.UserTokenEmptyException;
import com.example.ecommerce.exception.UserWrongInputException;
import com.example.ecommerce.response.UserDetailResponse;
import com.example.ecommerce.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(UserWrongInputException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public UserResponse userWrongInput(UserWrongInputException e) {
        return new UserResponse(HttpStatus.NOT_FOUND + "", e.getMessage());
    }

    @ExceptionHandler(UserTokenEmptyException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public UserDetailResponse userTokenEmpty(UserWrongInputException e) {
        return new UserDetailResponse("INVALID_TOKEN", null);
    }

}
