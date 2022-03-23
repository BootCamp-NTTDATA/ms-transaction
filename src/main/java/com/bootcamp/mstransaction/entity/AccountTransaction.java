package com.bootcamp.mstransaction.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AccountTransaction extends BaseEntity{
    private  String code;
    private String accountNumber;
    private Float amount;
    private LocalDateTime transactionDate;
    private String  AccountTransactionType; // si deposito o retiro
    private Client client;
    private AccountClient clientAccount;
}
