package com.bootcamp.mstransaction.webclient;

import com.bootcamp.mstransaction.exception.CreditNotFoundException;
import com.bootcamp.mstransaction.webclient.dto.ClientCreditDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class RegisterProductClientServiceImpl implements IRegisterProductClientService{

    private static final String BASE_URL = "lb://ms-register-product-client";

    @Autowired
    private WebClient.Builder webClient;

    @Override
    public Mono<ClientCreditDto> findCreditByClient(String numberDocument, String documentType, String codCredit) {
        return webClient.baseUrl(BASE_URL).build().get().uri("/api/register/credit/client/code/".concat(codCredit).concat("/number/").concat(numberDocument).concat("/document/").concat(documentType))
                .retrieve()
                .bodyToMono(ClientCreditDto.class)
                .onErrorResume(error->{
                    WebClientResponseException response = (WebClientResponseException) error;
                    if(response.getStatusCode() == HttpStatus.NOT_FOUND) {
                        return Mono.error(new CreditNotFoundException());
                    }
                    return Mono.error(error);
                });
    }
}
