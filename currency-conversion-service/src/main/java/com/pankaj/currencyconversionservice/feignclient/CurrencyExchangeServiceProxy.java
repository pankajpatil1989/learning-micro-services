package com.pankaj.currencyconversionservice.feignclient;

import com.pankaj.currencyconversionservice.model.CurrencyConversion;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange-service",url="localhost:8000") // url is hardcoded
//@FeignClient(name="currency-exchange-service") // To invoke another service
@FeignClient(name="netflix-zuul-api-gateway-server")  // invoke API through Zuul API gateway
@RibbonClient(name="currency-exchange-service") // For load balancing
public interface CurrencyExchangeServiceProxy {

    @GetMapping(value = "/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
