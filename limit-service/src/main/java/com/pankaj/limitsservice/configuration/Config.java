package com.pankaj.limitsservice.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("limits-service")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Config {
    private int max;
    private int min;
}

