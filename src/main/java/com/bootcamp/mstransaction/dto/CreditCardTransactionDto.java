package com.bootcamp.mstransaction.dto;

import com.bootcamp.mstransaction.entity.Client;
import com.bootcamp.mstransaction.entity.CreditCardClient;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreditCardTransactionDto {
    private String id;
    private String code;
    private Float amount;
    private LocalDateTime transactionDate;
    private String typeCardTransaction; //Pagos o consumos
    private Client client;
    private CreditCardClient creditCardClient;
}
