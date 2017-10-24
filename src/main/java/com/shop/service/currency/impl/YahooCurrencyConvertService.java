package com.shop.service.currency.impl;

import com.shop.service.currency.CurrencyConvertService;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class YahooCurrencyConvertService implements CurrencyConvertService {

    public YahooCurrencyConvertService() {
    }

    public double getExchangeRate(String from, String to) throws IOException {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        HttpGet httpGet = new HttpGet("http://quote.yahoo.com/d/quotes.csv?s=" + from + to + "=X&f=l1&e=.csv");
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseBody = closeableHttpClient.execute(httpGet, responseHandler);
        return Double.valueOf(responseBody);
    }
}
