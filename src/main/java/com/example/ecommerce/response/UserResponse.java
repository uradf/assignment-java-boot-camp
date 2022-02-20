package com.example.ecommerce.response;

public class UserResponse {
    private String msg;
    private String token;

    public UserResponse() {
    }

    public UserResponse(String msg, String token) {
        this.msg = msg;
        this.token = token;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
