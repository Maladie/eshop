package com.shop.service.currency;

import java.io.IOException;

public interface CurrencyConvertService {

    double getExchangeRate(String from, String to) throws IOException;
}
