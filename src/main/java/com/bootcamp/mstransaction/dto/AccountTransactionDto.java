package com.bootcamp.mstransaction.dto;

import com.bootcamp.mstransaction.entity.AccountClient;
import com.bootcamp.mstransaction.entity.Client;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AccountTransactionDto {
    private  String id;
    private  String code;
    private String accountNumber;
    private Float amount;
    private LocalDateTime transactionDate;
    private String  AccountTransactionType; // si deposito o retiro
    private Client client;
    private AccountClient clientAccount;
}
