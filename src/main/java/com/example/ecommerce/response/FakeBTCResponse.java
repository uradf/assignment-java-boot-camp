package com.example.ecommerce.response;

public class FakeBTCResponse {

    private String msg;
    private float BTC;

    public FakeBTCResponse() {
    }

    public FakeBTCResponse(String msg, float BTC) {
        this.msg = msg;
        this.BTC = BTC;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public float getBTC() {
        return BTC;
    }

    public void setBTC(float BTC) {
        this.BTC = BTC;
    }
}
