package com.bootcamp.mstransaction.service;

import com.bootcamp.mstransaction.entity.AccountTransaction;
import com.bootcamp.mstransaction.repository.IAccountTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountTransactionServiceImpl implements IAccountTransactionService{
    @Autowired
    IAccountTransactionRepository iAccountTransactionRepository;
    @Override
    public Mono<AccountTransaction> save(AccountTransaction accountTransaction) {
        return iAccountTransactionRepository.save(accountTransaction);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return iAccountTransactionRepository.deleteById(id);
    }

    @Override
    public Mono<AccountTransaction> findById(String id) {
        return iAccountTransactionRepository.findById(id);
    }

    @Override
    public Flux<AccountTransaction> findAll() {
        return iAccountTransactionRepository.findAll();
    }
}
