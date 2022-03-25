package com.bootcamp.mstransaction.resource;

import com.bootcamp.mstransaction.dto.CreditTransactionDto;
import com.bootcamp.mstransaction.dto.PaymentDto;
import com.bootcamp.mstransaction.entity.CreditClient;
import com.bootcamp.mstransaction.entity.CreditTransaction;
import com.bootcamp.mstransaction.service.ICreditTransactionService;
import com.bootcamp.mstransaction.util.MapperUtil;
import com.bootcamp.mstransaction.webclient.IRegisterProductClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class CreditTransactionResource extends MapperUtil {

    @Autowired
    private ICreditTransactionService iCreditTransactionService;

    @Autowired
    IRegisterProductClientService iRegisterProductClientService;


    public Mono<CreditTransactionDto> payment(PaymentDto paymentDto) {
        CreditTransaction creditTransaction= new CreditTransaction();
        return iRegisterProductClientService.findCreditByClient(paymentDto.getNumberDocument(),paymentDto.getTypeDocument(),paymentDto.getCode())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(creditClientDto -> {
                    if(creditClientDto.getCreditAmount() > paymentDto.getAmount() ){
                        creditTransaction.setAmount(paymentDto.getAmount());
                        creditTransaction.setPaymentDate(LocalDateTime.now());
                        creditTransaction.setCreatedAt(LocalDateTime.now());
                        creditTransaction.setCreditClient(map(creditClientDto,CreditClient.class));
                        return iCreditTransactionService.save(creditTransaction).map(x->map(x,CreditTransactionDto.class));
                    }
                    return Mono.error(new Exception());
                });
    }
    
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
