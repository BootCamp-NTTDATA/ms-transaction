package com.bootcamp.mstransaction.webclient.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditClientDto {
    private String id;
    private String code;
    private Float creditAmount;
    private Float interestRate;
    private Client client;
    private CreditType creditType;
    private BankAccount bankAccount;
    private boolean state;
}
