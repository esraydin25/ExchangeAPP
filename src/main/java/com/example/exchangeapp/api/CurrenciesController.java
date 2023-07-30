package com.example.exchangeapp.api;

import com.example.exchangeapp.service.CurrencyService;
import com.example.exchangeapp.dto.GetAllCurrenciesResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/currencies")
public class CurrenciesController {
    private final CurrencyService service;

    @GetMapping
    public List<GetAllCurrenciesResponse> getAll(){
        return service.getAll();
    }

    @PostMapping
    public void add(){
        service.add();
    }

}
