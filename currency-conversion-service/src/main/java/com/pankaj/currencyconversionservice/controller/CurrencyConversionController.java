package com.pankaj.currencyconversionservice.controller;

import com.pankaj.currencyconversionservice.feignclient.CurrencyExchangeServiceProxy;
import com.pankaj.currencyconversionservice.model.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CurrencyEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrency(
            @PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){

        // Feign Problem-1
        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);

        ResponseEntity<CurrencyConversion> response = new RestTemplate().getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}"
                ,CurrencyConversion.class,uriVariables);
        CurrencyConversion currencyConversion = response.getBody();

        return new CurrencyConversion(currencyConversion.getId(),from,to,
                currencyConversion.getConversionMultiple(),quantity,
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getPort());
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrencyFeign(
            @PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){


        CurrencyConversion currencyConversion = currencyExchangeServiceProxy.retrieveExchangeValue(from,to);
        log.info("CurrencyConversionController::convertCurrencyFeign() currencyConversion {}", currencyConversion.toString());
        return new CurrencyConversion(currencyConversion.getId(),from,to,
                currencyConversion.getConversionMultiple(),quantity,
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getPort());
    }
}
