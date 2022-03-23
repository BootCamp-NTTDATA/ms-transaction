package com.bootcamp.mstransaction.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreditCardTransaction extends BaseEntity {
    private String code;
    private Float amount;
    private LocalDateTime transactionDate;
    private String typeTransaction;
    private Client client;
    private CreditCardClient creditCardClient;
}
