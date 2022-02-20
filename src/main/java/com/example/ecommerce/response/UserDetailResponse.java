package com.example.ecommerce.response;

import com.example.ecommerce.entity.User;

import java.util.Optional;

public class UserDetailResponse {
    private String msg;
    private Optional<User> userDetail;

    public UserDetailResponse(String msg, Optional<User> userDetail) {
        this.msg = msg;
        this.userDetail = userDetail;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Optional<User> getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(Optional<User> userDetail) {
        this.userDetail = userDetail;
    }
}
