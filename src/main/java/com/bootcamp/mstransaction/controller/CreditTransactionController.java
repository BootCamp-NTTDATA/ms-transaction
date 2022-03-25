package com.bootcamp.mstransaction.controller;

import com.bootcamp.mstransaction.dto.CreditTransactionDto;
import com.bootcamp.mstransaction.dto.PaymentDto;
import com.bootcamp.mstransaction.resource.CreditTransactionResource;
import com.bootcamp.mstransaction.webclient.dto.CreditClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transaction/credit")
public class CreditTransactionController {
    @Autowired
    private CreditTransactionResource creditTransactionResource;

    @PostMapping
    public Mono<CreditTransactionDto> create(@RequestBody CreditTransactionDto creditTransactionDto){
        return creditTransactionResource.create(creditTransactionDto);
    }

    @PutMapping
    public Mono<CreditTransactionDto> update(@RequestBody CreditTransactionDto creditTransactionDto){
        return creditTransactionResource.update(creditTransactionDto);
    }

    @GetMapping
    public Flux<CreditTransactionDto> findAll(){
        return creditTransactionResource.findAll();
    }

    @DeleteMapping
    public Mono<Void> delete(@RequestBody CreditTransactionDto creditTransactionDto){
        return creditTransactionResource.delete(creditTransactionDto);
    }

    @PostMapping("/payment")
    public Mono<CreditTransactionDto> createPayment(@RequestBody PaymentDto paymentDto){
        return creditTransactionResource.payment(paymentDto);
    }
}
