package com.bootcamp.mstransaction.resource;

import com.bootcamp.mstransaction.dto.CreditTransactionDto;
import com.bootcamp.mstransaction.entity.CreditTransaction;
import com.bootcamp.mstransaction.service.ICreditTransactionService;
import com.bootcamp.mstransaction.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditTransactionResource extends MapperUtil {

    @Autowired
    private ICreditTransactionService iCreditTransactionService;

    public Mono<CreditTransactionDto> create(CreditTransactionDto creditTransactionDto) {
        CreditTransaction creditTransaction = map(creditTransactionDto, CreditTransaction.class);
        return iCreditTransactionService.save(creditTransaction)
                .map(x -> map(x, CreditTransactionDto.class));
    }

    public Mono<CreditTransactionDto> update(CreditTransactionDto creditTransactionDto) {
        CreditTransaction  creditTransaction= map(creditTransactionDto, CreditTransaction.class);
        return iCreditTransactionService.findById(creditTransactionDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(y -> iCreditTransactionService.save(creditTransaction).map(x -> map(x, CreditTransactionDto.class)));
    }

    public Mono<Void> delete(CreditTransactionDto creditTransactionDto) {
        return iCreditTransactionService.findById(creditTransactionDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(x -> iCreditTransactionService.deleteById(creditTransactionDto.getId()));
    }

    public Flux<CreditTransactionDto> findAll() {

        return iCreditTransactionService.findAll()
                .map(x -> map(x, CreditTransactionDto.class));
    }

    public Mono<CreditTransactionDto> findById(String id) {
        return iCreditTransactionService.findById(id).map(x -> map(x, CreditTransactionDto.class));
    }

}
