package com.example.currencyconversion.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromCurrency;
    private String toCurrency;
    private double originalAmount;
    private double convertedAmount;
    private double exchangeRate;

    private LocalDateTime timestamp;

    public Transaction() {
    }

    public Transaction(String fromCurrency, String toCurrency, double originalAmount,
                       double convertedAmount, double exchangeRate, LocalDateTime timestamp) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.originalAmount = originalAmount;
        this.convertedAmount = convertedAmount;
        this.exchangeRate = exchangeRate;
        this.timestamp = timestamp;
    }

    // Getters and Setters
}