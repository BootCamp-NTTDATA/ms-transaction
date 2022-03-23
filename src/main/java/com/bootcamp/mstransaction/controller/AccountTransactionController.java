package com.bootcamp.mstransaction.controller;

import com.bootcamp.mstransaction.dto.AccountTransactionDto;
import com.bootcamp.mstransaction.resource.AccountTransactionResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transaction/account")
public class AccountTransactionController {

    @Autowired
    private AccountTransactionResource accountTransactionResource;

    @PostMapping
    public Mono<AccountTransactionDto> create(@RequestBody AccountTransactionDto accountTransactionDto){
        return accountTransactionResource.create(accountTransactionDto);
    }
    @PutMapping
    public Mono<AccountTransactionDto> update(@RequestBody AccountTransactionDto accountTransactionDto){
        return accountTransactionResource.update(accountTransactionDto);
    }

    @GetMapping
    public Flux<AccountTransactionDto> findAll(){
        return accountTransactionResource.findAll();
    }

    @DeleteMapping
    public Mono<Void> delete(@RequestBody AccountTransactionDto accountTransactionDto){
        return accountTransactionResource.delete(accountTransactionDto);
    }
}
