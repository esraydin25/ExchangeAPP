package com.example.exchangeapp.repository;

import com.example.exchangeapp.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency,Integer> {
    Currency findByCurrencyName(String currencyName);
    boolean existsByCurrencyNameIgnoreCase(String name);


}
