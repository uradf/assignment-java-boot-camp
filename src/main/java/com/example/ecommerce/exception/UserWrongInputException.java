package com.example.ecommerce.exception;

public class UserWrongInputException extends RuntimeException{

    public UserWrongInputException(String userId) {
        super(userId);
    }
}
