package com.example.exchangeapp;

import com.example.exchangeapp.model.Currency;
import com.example.exchangeapp.service.CurrencyService;
import com.example.exchangeapp.service.CurrencyServiceImpl;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class ExchangeAppApplication {

    public static void main(String[] args ) {

        SpringApplication.run(ExchangeAppApplication.class, args);

    }

}
