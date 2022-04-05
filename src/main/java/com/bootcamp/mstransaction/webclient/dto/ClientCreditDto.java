package com.bootcamp.mstransaction.webclient.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientCreditDto {
    private String id;
    private String code;
    private BigDecimal amountGiven;
    private BigDecimal amountPaid;
    private int fees;
    private int feesPaid;
    private Client client;
    private TypeCredit typeCredit;
    private boolean state;
}
