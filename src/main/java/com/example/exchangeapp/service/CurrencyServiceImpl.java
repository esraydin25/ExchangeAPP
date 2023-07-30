package com.example.exchangeapp.service;

import com.example.exchangeapp.model.Currency;
import com.example.exchangeapp.repository.CurrencyRepository;
import com.example.exchangeapp.dto.GetAllCurrenciesResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CurrencyServiceImpl implements CurrencyService{

    private final ModelMapper modelMapper;
    private final CurrencyRepository repository;


    @Override
    public List<GetAllCurrenciesResponse> getAll() {
         List<Currency> currencies=repository.findAll();
         List<GetAllCurrenciesResponse> responses=currencies
                 .stream()
                 .map(currency -> modelMapper.map(currency,GetAllCurrenciesResponse.class))
                 .toList();
        return responses;
    }

    @Override
    public void add() {
        String json=new JsonWriter().getConvertJsonDataToString();
        List<Currency> currencyList=new JsonParser().getJsonStringParser(json);
        for(Currency currency:currencyList){
            repository.save(currency);
        }
    }
}
