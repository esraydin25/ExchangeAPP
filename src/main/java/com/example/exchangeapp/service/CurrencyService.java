package com.example.exchangeapp.service;

import com.example.exchangeapp.dto.GetAllCurrenciesResponse;

import java.util.List;

public interface CurrencyService {
    List<GetAllCurrenciesResponse> getAll();
    void add();
}
