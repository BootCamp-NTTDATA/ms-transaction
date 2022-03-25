package com.bootcamp.mstransaction.entity;

import com.bootcamp.mstransaction.webclient.dto.BankAccount;
import com.bootcamp.mstransaction.webclient.dto.Client;
import com.bootcamp.mstransaction.webclient.dto.CreditType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditClient {
    private String id;
    private String code;
    private Float creditAmount;
    private Float interestRate;
    private Client client;
    private CreditType creditType;
    private BankAccount bankAccount;
    private boolean state;
}
