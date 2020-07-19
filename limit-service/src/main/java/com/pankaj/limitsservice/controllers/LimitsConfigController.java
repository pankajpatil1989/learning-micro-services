package com.pankaj.limitsservice.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.pankaj.limitsservice.configuration.Config;
import com.pankaj.limitsservice.model.LimitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LimitsConfigController {

    @Autowired
    private Config config;

    @GetMapping("/limits")
    public LimitConfig retrieveLimitFromConfig(){
        log.info("LimitsConfigController:retrieveLimitFromConfig(): Max {} Min {}",config.getMax(),config.getMin());
        return new LimitConfig(config.getMax(),config.getMin());
    }

    @GetMapping("/fault-tolerance-example")
    @HystrixCommand(fallbackMethod = "fallbackRetrieveFromConfig")
    public LimitConfig retrieveFromConfig(){
        log.info("LimitsConfigController:retrieveFromConfig(): throwing hardcoded runtime error");
        new RuntimeException("throwing hardcoded runtime error");
        return null;
    }

    public LimitConfig fallbackRetrieveFromConfig() {
        log.info("LimitsConfigController:fallbackRetrieveFromConfig(): hardcoded Max=999 Min=9");
        return new LimitConfig(9999,9);
    }

}
