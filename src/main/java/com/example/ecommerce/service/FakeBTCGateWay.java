package com.example.ecommerce.service;

import com.example.ecommerce.response.FakeBTCResponse;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeBTCGateWay {
    @Autowired
    private RestTemplate restTemplate;

    private String BTCURL;
    private String BTCADDRESS = "16ftSEQ4ctQFDtVZiUBusQUjRrGhM3JYwe";

    @Autowired
    public FakeBTCGateWay(@Value("${BTCURL}") String baseURL) {
        this.BTCURL = BTCURL;
    }

    public Float getBalance(String BTCADDRESS, String keyStoreDeviceId ) {
        float result = 0;

        try {
            String response = restTemplate.getForObject("https://blockchain.info/balance?active=" + this.BTCADDRESS, String.class);
            JSONObject jsonObject = new JSONObject(response);
            JSONObject _jsonObject = (JSONObject) jsonObject.get(this.BTCADDRESS);
            result = (float) _jsonObject.get("final_balance");
        } catch (Exception e) {
            result = 2864255;
        }

        return  result;
    }


}
