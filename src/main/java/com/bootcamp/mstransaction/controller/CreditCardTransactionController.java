package com.bootcamp.mstransaction.controller;

import com.bootcamp.mstransaction.dto.CreditCardTransactionDto;
import com.bootcamp.mstransaction.resource.CreditCardTransactionResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transaction/credit-card")
public class CreditCardTransactionController {
    @Autowired
    private CreditCardTransactionResource creditCardTransactionResource;

    @PostMapping
    public Mono<CreditCardTransactionDto> create(@RequestBody CreditCardTransactionDto creditCardTransactionDto){
        return creditCardTransactionResource.create(creditCardTransactionDto);
    }
    @PutMapping
    public Mono<CreditCardTransactionDto> update(@RequestBody CreditCardTransactionDto creditCardTransactionDto){
        return creditCardTransactionResource.update(creditCardTransactionDto);
    }

    @GetMapping
    public Flux<CreditCardTransactionDto> findAll(){
        return creditCardTransactionResource.findAll();
    }

    @DeleteMapping
    public Mono<Void> delete(@RequestBody CreditCardTransactionDto creditCardTransactionDto){
        return creditCardTransactionResource.delete(creditCardTransactionDto);
    }
}
