package com.bootcamp.mstransaction.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditClient {
    private String code;
    private Float  creditAmount;
    private boolean state;
}
