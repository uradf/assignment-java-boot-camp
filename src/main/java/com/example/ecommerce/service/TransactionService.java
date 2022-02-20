package com.example.ecommerce.service;

import com.example.ecommerce.repository.CartRepository;
import com.example.ecommerce.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionsRepository transactionsRepository;

    @Autowired
    CartRepository cartRepository;

    public void saveTransaction(String token, String userid) {
    }
}
