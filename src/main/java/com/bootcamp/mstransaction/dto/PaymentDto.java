package com.bootcamp.mstransaction.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDto {
    private Float amount;
    private String code;
    private String typeDocument;
    private String numberDocument;
}
