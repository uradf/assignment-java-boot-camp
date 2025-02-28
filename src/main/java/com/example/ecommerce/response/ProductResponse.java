package com.example.ecommerce.response;

import com.example.ecommerce.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public class ProductResponse {
    private String msg;
    private Page<Product> products;

    public ProductResponse() {
    }

    public ProductResponse(String msg, Page<Product> products) {
        this.msg = msg;
        this.products = products;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Page<Product> getProducts() {
        return products;
    }

    public void setProducts(Page<Product> products) {
        this.products = products;
    }
}
