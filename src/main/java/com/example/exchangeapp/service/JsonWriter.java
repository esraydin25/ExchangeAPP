package com.example.exchangeapp.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonWriter {

    //This method converts JSON data in the API to string
    public  String getConvertJsonDataToString() {
        String result ="";
        try {
            URL url  = new URL("https://finans.truncgil.com/today.json");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            while((line = bufferedReader.readLine()) != null){
                result += line;
            }
            bufferedReader.close();

        }catch(Exception e) {
            System.out.println(e);
        }
        return result;
    }
}
