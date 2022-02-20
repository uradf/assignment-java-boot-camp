package com.example.ecommerce.controller;

import com.example.ecommerce.service.FakeBTCGateWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    FakeBTCGateWay fakeBTCGateWay;


    @GetMapping( value = "/getBalance/{addr}/{deviceKeyStore}"
    )
    public Float getBalance(@PathVariable String addr, @PathVariable String deviceKeyStore) {
        return fakeBTCGateWay.getBalance(addr, deviceKeyStore);
    }

    @PostMapping("/purchase")
    public void purchase() {
    }
}
