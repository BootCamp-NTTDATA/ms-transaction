package com.bootcamp.mstransaction.service;

import com.bootcamp.mstransaction.entity.CreditTransaction;
import com.bootcamp.mstransaction.util.ICrud;
import reactor.core.publisher.Flux;

public interface ICreditTransactionService extends ICrud<CreditTransaction, String> {
    Flux<CreditTransaction> findCreditTransactionCode(String code);
}
