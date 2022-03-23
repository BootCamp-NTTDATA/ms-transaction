package com.bootcamp.mstransaction.repository;

import com.bootcamp.mstransaction.entity.CreditCardTransaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreditCardTransactionRepository  extends ReactiveMongoRepository<CreditCardTransaction, String> {
}
