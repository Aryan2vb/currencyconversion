package com.example.currencyconversion.controller;

import com.example.currencyconversion.service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class CurrencyConversionController {

    @Autowired
    private CurrencyConversionService conversionService;

    @GetMapping("/rates")
    public Map<String, Double> getExchangeRates(@RequestParam String baseCurrency) {
        return conversionService.getExchangeRates(baseCurrency);
    }

    @GetMapping("/convert")
    public double convertCurrency(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double amount) {
        return conversionService.convertCurrency(from, to, amount);
    }
}