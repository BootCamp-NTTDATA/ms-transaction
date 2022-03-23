package com.bootcamp.mstransaction.repository;

import com.bootcamp.mstransaction.entity.AccountTransaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountTransactionRepository  extends ReactiveMongoRepository<AccountTransaction, String> {
}
