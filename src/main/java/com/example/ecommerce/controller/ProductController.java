package com.example.ecommerce.controller;

import com.example.ecommerce.response.ProductResponse;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    final String API = "/api/v1";
    final int SIZE = 5;

    @Autowired
    ProductService productService;

    @GetMapping(API + "/products")
    public ProductResponse getProductsByPage(@RequestParam(defaultValue = "0") int page) {
        Pageable paging = PageRequest.of(page, SIZE);
        return new ProductResponse("products/{page}", productService.getProductsByPage(paging));
    }

    @GetMapping(API + "/products/by")
    public ProductResponse getProductsByName(@RequestParam(defaultValue = "0") int page, @RequestParam String name) {
        Pageable paging = PageRequest.of(page, SIZE);
        return new ProductResponse("products/{name}", productService.getProductsByName(name, paging));
    }
}
