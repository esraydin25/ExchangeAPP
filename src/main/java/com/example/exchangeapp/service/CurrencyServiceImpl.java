package com.example.exchangeapp.service;

import com.example.exchangeapp.model.Currency;
import com.example.exchangeapp.repository.CurrencyRepository;
import com.example.exchangeapp.service.dto.CreateCurrencyResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CurrencyImpl implements CurrencyService{

    private final ModelMapper modelMapper;
    private final CurrencyRepository repository;
    @Override
    public List<CreateCurrencyResponse> add() {
        for(Currency currency:currencyList){
             repository.save(currency);
        }
        List<CreateCurrencyResponse> responses=currencyList
                .stream()
                .map(currency -> modelMapper.map(currency, CreateCurrencyResponse.class))
                .toList();
        return responses;
    }
}
