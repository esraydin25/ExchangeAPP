package com.example.exchangeapp.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCurrenciesResponse {
    private int id;
    private String currencyName;
    private String currencyUnit;
    private String buying;
    private String selling;
    private String change ;
}
