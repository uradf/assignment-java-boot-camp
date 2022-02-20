package com.example.ecommerce.response;

public class ItemToCartResponse {

    private String msg;
    private String result;

    public ItemToCartResponse() {
    }

    public ItemToCartResponse(String msg, String result) {
        this.msg = msg;
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
