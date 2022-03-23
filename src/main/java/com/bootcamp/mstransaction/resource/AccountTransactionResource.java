package com.bootcamp.mstransaction.resource;

import com.bootcamp.mstransaction.dto.AccountTransactionDto;
import com.bootcamp.mstransaction.entity.AccountTransaction;
import com.bootcamp.mstransaction.service.IAccountTransactionService;
import com.bootcamp.mstransaction.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountTransactionResource extends MapperUtil {

    @Autowired
    private IAccountTransactionService iAccountTransactionService;

    public Mono<AccountTransactionDto> create(AccountTransactionDto accountTransactionDto) {
        AccountTransaction accountTransaction = map(accountTransactionDto, AccountTransaction.class);
        return iAccountTransactionService.save(accountTransaction)
                .map(x -> map(x, AccountTransactionDto.class));
    }

    public Mono<AccountTransactionDto> update(AccountTransactionDto accountTransactionDto) {
        AccountTransaction  accountTransaction= map(accountTransactionDto, AccountTransaction.class);
        return iAccountTransactionService.findById(accountTransactionDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(y -> iAccountTransactionService.save(accountTransaction).map(x -> map(x, AccountTransactionDto.class)));
    }

    public Mono<Void> delete(AccountTransactionDto accountTransactionDto) {
        return iAccountTransactionService.findById(accountTransactionDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(x -> iAccountTransactionService.deleteById(accountTransactionDto.getId()));
    }

    public Flux<AccountTransactionDto> findAll() {
        return iAccountTransactionService.findAll()
                .map(x -> map(x, AccountTransactionDto.class));
    }

    public Mono<AccountTransactionDto> findById(String id) {
        return iAccountTransactionService.findById(id).map(x -> map(x, AccountTransactionDto.class));
    }
}
