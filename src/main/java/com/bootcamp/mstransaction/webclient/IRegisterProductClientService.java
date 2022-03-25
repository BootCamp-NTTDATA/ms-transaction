package com.bootcamp.mstransaction.webclient;

import com.bootcamp.mstransaction.webclient.dto.CreditClientDto;
import reactor.core.publisher.Mono;

public interface IRegisterProductClientService {
    Mono<CreditClientDto> findCreditByClient(String numberDocument, String documentType, String codCredit);

}
