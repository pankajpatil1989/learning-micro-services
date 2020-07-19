package com.pankaj.currencyexchangeservice.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class ExchangeValue {

    @Id
    @GeneratedValue
    @NonNull
    private Long id;

    @Column(name="currency_from")
    @NonNull
    private String from;

    @Column(name="currency_to")
    @NonNull
    private String to;

    @NonNull
    private BigDecimal conversionMultiple;

    private int port;


}
