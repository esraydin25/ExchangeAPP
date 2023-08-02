package com.example.exchangeapp.service;

import com.example.exchangeapp.dto.GetCurrencyResponse;
import com.example.exchangeapp.model.Currency;
import com.example.exchangeapp.repository.CurrencyRepository;
import com.example.exchangeapp.dto.GetAllCurrenciesResponse;
import lombok.AllArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CurrencyServiceImpl implements CurrencyService, JsonParser<Currency> {
    private static String[]  currencyUnit={"USD","EUR","GBP","CHF","CAD","RUB","AED","AUD","gram-altin","ceyrek-altin","tam-altin"
            ,"cumhuriyet-altini","14-ayar-altin","18-ayar-altin","resat-altin","gumus"};



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
    public GetCurrencyResponse getByCurrencyName(String currencyName)  {
        checkIfCurrencyExistsByName(currencyName);

        Currency currency=repository.findByCurrencyName(currencyName);
        GetCurrencyResponse response=modelMapper.map(currency,GetCurrencyResponse.class);

        return response;
    }

    @Override
    public void add() {
        String json=new JsonWriter().getConvertJsonDataToString();//url den json bilgilerini çekiyor
        List<Currency> currencies=getJsonStringParser(json);
        for(Currency currency:currencies){
            repository.save(currency);
        }

    }
    @Override
    public void delete(int id) {
        repository.deleteById(id);

    }
    @Override
    public List<Currency> getJsonStringParser(String json) {
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

    private  void checkIfCurrencyExistsByName(String currencyName) {
       if(!repository.existsByCurrencyNameIgnoreCase(currencyName))
          throw new RuntimeException("Currency name not exists!");
    }

}


