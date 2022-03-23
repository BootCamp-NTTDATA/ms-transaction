package com.bootcamp.mstransaction.service;

import com.bootcamp.mstransaction.entity.CreditCardTransaction;
import com.bootcamp.mstransaction.repository.ICreditCardTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditCardTransactionImpl implements ICreditCardTransactionService{
    @Autowired
    ICreditCardTransactionRepository iCreditCardTransactionRepository;
    @Override
    public Mono<CreditCardTransaction> save(CreditCardTransaction creditCardTransaction) {
        return iCreditCardTransactionRepository.save(creditCardTransaction);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return iCreditCardTransactionRepository.deleteById(id);
    }

    @Override
    public Mono<CreditCardTransaction> findById(String id) {
        return iCreditCardTransactionRepository.findById(id);
    }

    @Override
    public Flux<CreditCardTransaction> findAll() {
        return iCreditCardTransactionRepository.findAll();
    }
}
