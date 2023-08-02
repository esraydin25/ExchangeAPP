package com.example.exchangeapp.service;

import java.util.List;

public interface JsonParser<T> {
    List<T> getJsonStringParser(String json);
}
