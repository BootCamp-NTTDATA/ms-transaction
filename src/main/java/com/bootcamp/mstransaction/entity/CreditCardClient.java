package com.bootcamp.mstransaction.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCardClient {
    private String code;
    private Float amountLimit;
    private Float interest;
    private boolean state;
}
