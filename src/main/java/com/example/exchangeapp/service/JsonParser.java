package com.example.exchangeapp.service;

import com.example.exchangeapp.model.Currency;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class JsonParser {
    //This class converts the JSON string to currency obje
    private static String[]  currencyUnit={"USD","EUR","GBP","CHF","CAD","RUB","AED","AUD","gram-altin","ceyrek-altin","tam-altin"
            ,"cumhuriyet-altini","14-ayar-altin","18-ayar-altin","resat-altin","gumus"};


    public  List<Currency> getJsonStringParser(String json){

        List<Currency> currencies=new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(json);
            JSONArray jsonArray = new JSONArray();
            for(int j=0;j<16;j++) {
                Currency currency=new Currency();
                jsonArray.add(jsonObject.get(currencyUnit[j]));
                currency.setCurrencyName(currencyUnit[j]);
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject object = (JSONObject) jsonArray.get(i);
                    currency.setBuying((String) object.get("Alış"));
                    currency.setSelling((String) object.get("Satış"));
                    currency.setChange((String) object.get("Değişim"));
                    currency.setCurrencyUnit((String) object.get("Tür"));
                }
                currencies.add(currency);
            }


        } catch (ParseException e) {
            System.out.println("ParseException Hatası !\n" + e);
        }
        return currencies;
    }


}
