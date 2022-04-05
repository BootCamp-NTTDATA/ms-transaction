package com.bootcamp.mstransaction.webclient.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client {
    private String idClient;
    private String documentType;
    private String numberDocument;
    private String name;
    private String clientType;
}
