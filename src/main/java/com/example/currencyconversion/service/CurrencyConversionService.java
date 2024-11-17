package com.example.currencyconversion.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CurrencyConversionService {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/54d1329d3bfe11db7bf6b8db/latest/{baseCurrency}";

    public Map<String, Double> getExchangeRates(String baseCurrency) {
        RestTemplate restTemplate = new RestTemplate();
        var response = restTemplate.getForObject(API_URL, ExchangeRateResponse.class, baseCurrency);

        if (response != null && "success".equals(response.result)) {
            return response.conversion_rates;
        }

        throw new IllegalArgumentException("Failed to fetch exchange rates. Please check the base currency or API key.");
    }

    public double convertCurrency(String from, String to, double amount) {
        Map<String, Double> rates = getExchangeRates(from);
        if (rates.containsKey(to)) {
            return amount * rates.get(to);
        }

        throw new IllegalArgumentException("Invalid target currency code: " + to);
    }

    // Internal class to map API response
    private static class ExchangeRateResponse {
        public String result;
        public Map<String, Double> conversion_rates;
    }
}