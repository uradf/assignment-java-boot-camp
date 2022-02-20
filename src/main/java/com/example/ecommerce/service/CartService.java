package com.example.ecommerce.service;

import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.exception.UserTokenEmptyException;
import com.example.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    final String VALID_TOKEN = "VALID_TOKEN_STRING";

    public void setCartRepository(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getItemsByUser(String token) {

        if (token.equals("") || token == null) throw new UserTokenEmptyException();
        String userId = token.split("\\.")[0];
        String fakeToken = token.split("\\.")[1];
        if (!fakeToken.equals(VALID_TOKEN)) throw new UserTokenEmptyException();
        List<Cart> cart = cartRepository.findByUserid(userId);
        return cart;
    }

    public String addItemToCart(String token, int itemid) {
        if (token.equals("") || token == null) return "ERROR";
        String userId = token.split("\\.")[0];
        String fakeToken = token.split("\\.")[1];
        if (!fakeToken.equals(VALID_TOKEN)) return "ERROR";
        Cart itemCart = new Cart(userId, itemid);
        cartRepository.save(itemCart);
        return "COMPLETED";
    }


}
