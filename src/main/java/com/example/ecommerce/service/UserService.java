package com.example.ecommerce.service;

import com.example.ecommerce.entity.User;
import com.example.ecommerce.exception.UserTokenEmptyException;
import com.example.ecommerce.exception.UserWrongInputException;
import com.example.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UserService {

    final String VALID_TOKEN = "VALID_TOKEN_STRING";

    @Autowired
    UserRepository userRepository;

    public String getToken(String userId, String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(password.getBytes(),0, password.length());
        String hashedPass = new BigInteger(1,messageDigest.digest()).toString(16);
        if (hashedPass.length() < 32) {
            hashedPass = "0" + hashedPass;
        }
        Optional<User> user = userRepository.findByUseridAndPassword(userId, hashedPass);
        if (user.isPresent()) {
            return user.get().getUserId() + "." + VALID_TOKEN;
        }
        throw new UserWrongInputException(userId);
    }

    public Optional<User> getUserDetail(String token) {

        if (token.equals("") || token == null) throw new UserTokenEmptyException();
        String userId = token.split("\\.")[0];
        String fakeToken = token.split("\\.")[1];
        if (!fakeToken.equals(VALID_TOKEN)) throw new UserTokenEmptyException();
        Optional<User> userDetail = userRepository.findByUserid(userId);
        if (userDetail.isPresent()) return userDetail;
        throw new UserWrongInputException(userId);
    }
}
