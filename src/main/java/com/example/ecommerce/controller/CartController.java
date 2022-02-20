package com.example.ecommerce.controller;

import com.example.ecommerce.entity.ItemCart;
import com.example.ecommerce.response.CartResponse;
import com.example.ecommerce.response.ItemToCartResponse;
import com.example.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    final String API = "/api/v1";

    @Autowired
    CartService cartService;

    @GetMapping(API + "/cart")
    public CartResponse userDetail(@RequestHeader("e-com") String token) {
        return new CartResponse("/cart", cartService.getItemsByUser(token));
    }

    @PostMapping(API + "/cart")
    public ItemToCartResponse addItemToCart(@RequestHeader("e-com") String token, @RequestBody ItemCart itemid) {
        return new ItemToCartResponse("/cart", cartService.addItemToCart(token, itemid.getItemid()));
    }


}
