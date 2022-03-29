package com.bootcamp.mstransaction.service;

import com.bootcamp.mstransaction.entity.CreditTransaction;
import com.bootcamp.mstransaction.repository.ICreditTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditTransactionServiceImpl implements ICreditTransactionService {

    @Autowired
    ICreditTransactionRepository iCreditTransactionRepository;

    @Override
    public Mono<CreditTransaction> save(CreditTransaction creditTransaction) {
        return iCreditTransactionRepository.save(creditTransaction);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return iCreditTransactionRepository.deleteById(id);
    }

    @Override
    public Mono<CreditTransaction> findById(String id) {
        return iCreditTransactionRepository.findById(id);
    }

    @Override
    public Flux<CreditTransaction> findAll() {
        return iCreditTransactionRepository.findAll();
    }

    @Override
    public Flux<CreditTransaction> findCreditTransactionCode(String code) {
        return iCreditTransactionRepository.findByCreditClientCode(code);
    }
}
