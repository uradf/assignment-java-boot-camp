package com.example.ecommerce.service;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Page<Product> getProductsByName(String name, Pageable pageable) {
        return productRepository.findByName(name, pageable);
    }

    public Page<Product> getProductsByPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
