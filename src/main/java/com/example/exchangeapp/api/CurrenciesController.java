package com.example.exchangeapp.api;

import com.example.exchangeapp.dto.GetCurrencyResponse;
import com.example.exchangeapp.service.CurrencyService;
import com.example.exchangeapp.dto.GetAllCurrenciesResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{name}")
    public GetCurrencyResponse getByName(@PathVariable String name){
        return service.getByCurrencyName(name);
    }

    @PostMapping
    public void add(){
        service.add();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        service.delete(id);
    }

}
