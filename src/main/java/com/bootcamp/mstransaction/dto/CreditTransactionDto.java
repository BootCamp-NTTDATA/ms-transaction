package com.bootcamp.mstransaction.dto;

import com.bootcamp.mstransaction.entity.Client;
import com.bootcamp.mstransaction.entity.CreditClient;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreditTransactionDto {
    private String id;
    private Float amount;
    private LocalDateTime paymentDate;
    private CreditClient creditClient;
}
