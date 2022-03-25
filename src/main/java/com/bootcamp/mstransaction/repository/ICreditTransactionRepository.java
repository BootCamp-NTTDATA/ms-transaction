package com.bootcamp.mstransaction.repository;

import com.bootcamp.mstransaction.entity.CreditTransaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ICreditTransactionRepository extends ReactiveMongoRepository<CreditTransaction, String> {

    Flux<CreditTransaction> findByCode(String code);
}
