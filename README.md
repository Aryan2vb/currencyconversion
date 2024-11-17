
Currency Conversion 

This is a simple Currency Conversion built using Spring Boot that leverages the Exchange Rate API to fetch exchange rates and convert currencies. The application allows you to:
	•	Fetch real-time exchange rates for a base currency.
	•	Convert amounts between two different currencies based on the latest rates.

Features

	•	Fetch Exchange Rates: Get real-time conversion rates for a given base currency.
	•	Currency Conversion: Convert amounts from one currency to another based on the latest rates.

Prerequisites

Before you can run the project, make sure you have the following installed:
	•	Java Development Kit (JDK) (version 11 or later recommended)
	•	Maven (build tool for managing dependencies)
	•	API Key from Exchange Rate API

Getting Started

1. Clone the repository

git clone https://github.com/yourusername/currency-conversion-api.git
cd currency-conversion-api

2. Update the API Key

In the CurrencyConversionService.java file, replace the placeholder YOUR-API-KEY with your actual API Key from Exchange Rate API.

private static final String API_URL = "https://v6.exchangerate-api.com/v6/YOUR-API-KEY/latest/{baseCurrency}";

3. Build the Project

Using Maven, build the project and install dependencies:

mvn clean install

4. Run the Application

Run the application using Maven:

mvn spring-boot:run

The application will start on http://localhost:8080.

API Endpoints

1. Fetch Exchange Rates

GET /api/v1/rates?baseCurrency={baseCurrency}
	•	baseCurrency: The base currency code (e.g., USD, EUR).
	•	Response: A JSON object with the conversion rates for the base currency to others.

Example:

GET http://localhost:8080/api/v1/rates?baseCurrency=USD

Response:

{
    "USD": 1.0,
    "EUR": 0.9013,
    "INR": 82.56,
    "JPY": 110.27
}

2. Convert Currency

GET /api/v1/convert?from={fromCurrency}&to={toCurrency}&amount={amount}
	•	fromCurrency: The base currency you want to convert from (e.g., USD).
	•	toCurrency: The target currency you want to convert to (e.g., INR).
	•	amount: The amount you want to convert.

Example:

GET http://localhost:8080/api/v1/convert?from=USD&to=INR&amount=100

Response:

8256.0

Technologies Used

	•	Spring Boot: For building the backend API.
	•	Maven: For project management and dependencies.
	•	Exchange Rate API: To fetch real-time exchange rates.
