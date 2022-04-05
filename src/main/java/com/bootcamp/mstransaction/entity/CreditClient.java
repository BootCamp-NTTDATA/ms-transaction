package com.bootcamp.mstransaction.entity;

import com.bootcamp.mstransaction.webclient.dto.Client;
import com.bootcamp.mstransaction.webclient.dto.TypeCredit;
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
    private TypeCredit creditType;

    private boolean state;
}
