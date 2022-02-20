package com.example.ecommerce.response;

import com.example.ecommerce.entity.Cart;

import java.util.List;
import java.util.Optional;

public class CartResponse {

    private String msg;
    private List<Cart> cart;

    public CartResponse() {
    }

    public CartResponse(String msg, List<Cart> cart) {
        this.msg = msg;
        this.cart = cart;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }
}
