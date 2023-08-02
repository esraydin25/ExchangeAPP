package com.example.exchangeapp.service;

import com.example.exchangeapp.dto.GetAllCurrenciesResponse;
import com.example.exchangeapp.dto.GetCurrencyResponse;

import java.util.List;

public interface CurrencyService {
    List<GetAllCurrenciesResponse> getAll();

   GetCurrencyResponse getByCurrencyName(String currencyName);
    void add();

    void delete(int id);
}
