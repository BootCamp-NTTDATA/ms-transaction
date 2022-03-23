package com.bootcamp.mstransaction.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountClient {
    private String code;
    private String accountNumber;
    private boolean state;
}
