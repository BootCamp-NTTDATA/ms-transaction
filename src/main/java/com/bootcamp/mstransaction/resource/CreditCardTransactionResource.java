package com.bootcamp.mstransaction.resource;

import com.bootcamp.mstransaction.dto.CreditCardTransactionDto;
import com.bootcamp.mstransaction.entity.CreditCardTransaction;
import com.bootcamp.mstransaction.service.ICreditCardTransactionService;
import com.bootcamp.mstransaction.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditCardTransactionResource extends MapperUtil {

    @Autowired
    private ICreditCardTransactionService iCreditCardTransactionService;

    public Mono<CreditCardTransactionDto> create(CreditCardTransactionDto creditTransactionDto) {
        CreditCardTransaction creditCardTransaction = map(creditTransactionDto, CreditCardTransaction.class);
        return iCreditCardTransactionService.save(creditCardTransaction)
                .map(x -> map(x, CreditCardTransactionDto.class));
    }

    public Mono<CreditCardTransactionDto> update(CreditCardTransactionDto creditCardTransactionDto) {
        CreditCardTransaction  creditCardTransaction= map(creditCardTransactionDto, CreditCardTransaction.class);
        return iCreditCardTransactionService.findById(creditCardTransactionDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(y -> iCreditCardTransactionService.save(creditCardTransaction).map(x -> map(x, CreditCardTransactionDto.class)));
    }

    public Mono<Void> delete(CreditCardTransactionDto creditCardTransactionDto) {
        return iCreditCardTransactionService.findById(creditCardTransactionDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(x -> iCreditCardTransactionService.deleteById(creditCardTransactionDto.getId()));
    }

    public Flux<CreditCardTransactionDto> findAll() {
        return iCreditCardTransactionService.findAll()
                .map(x -> map(x, CreditCardTransactionDto.class));
    }

    public Mono<CreditCardTransactionDto> findById(String id) {
        return iCreditCardTransactionService.findById(id).map(x -> map(x, CreditCardTransactionDto.class));
    }
}
