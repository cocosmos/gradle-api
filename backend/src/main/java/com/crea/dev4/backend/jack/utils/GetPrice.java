package com.crea.dev4.backend.jack.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetPrice {
    /**
     * Get coin rate
     * 
     * @param idCoin   id of coingecko String (bitcoin)
     * @param currency Fiat String (usd)
     * @return rate of the token
     */
    public static float getCoinRate(String idCoin, String currency) {
        float price = 0.0f;
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "https://api.coingecko.com/api/v3/simple/price?ids=" + idCoin + "&vs_currencies="
                + currency;
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root;
        try {
            root = mapper.readTree(response.getBody());
            JsonNode name = root.path(idCoin).path(currency);
            price = Float.parseFloat(name.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return 1 / price;
    }

}
