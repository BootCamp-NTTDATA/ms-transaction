package com.bootcamp.mstransaction.webclient;

import com.bootcamp.mstransaction.webclient.dto.ClientCreditDto;
import reactor.core.publisher.Mono;

public interface IRegisterProductClientService {
    Mono<ClientCreditDto> findCreditByClient(String numberDocument, String documentType, String codCredit);

}
