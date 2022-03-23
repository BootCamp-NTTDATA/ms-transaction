package com.bootcamp.mstransaction.repository;

import com.bootcamp.mstransaction.entity.CreditTransaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreditTransactionRepository extends ReactiveMongoRepository<CreditTransaction, String> {
}
