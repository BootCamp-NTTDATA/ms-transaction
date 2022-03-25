package com.bootcamp.mstransaction.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreditTransaction extends BaseEntity {
    private Float amount;
    private LocalDateTime paymentDate;
    private CreditClient creditClient;

}
