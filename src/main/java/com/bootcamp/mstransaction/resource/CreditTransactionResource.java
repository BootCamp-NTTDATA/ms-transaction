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
        creditTransaction.setAmount(paymentDto.getAmount());
        creditTransaction.setPaymentDate(LocalDateTime.now());
        creditTransaction.setCreatedAt(LocalDateTime.now());
        return iRegisterProductClientService.findCreditByClient(paymentDto.getNumberDocument(),paymentDto.getTypeDocument(),paymentDto.getCode())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(creditClientDto -> {
                     return sumPayment(paymentDto.getCode()).flatMap(accumulatedAmount ->{
                         float x = creditClientDto.getAmountGiven().floatValue() - accumulatedAmount;
                         if ( x  == paymentDto.getAmount()){
                             return null;
                         }
                         if( x < paymentDto.getAmount()){
                             return Mono.error(new Exception());
                         }else{
                             creditTransaction.setCreditClient(map(creditClientDto,CreditClient.class));
                             return iCreditTransactionService.save(creditTransaction).map(y ->map(y,CreditTransactionDto.class));
                         }
                     });

                });
    }


    public Mono<Float> sumPayment(String code){
        return iCreditTransactionService.findCreditTransactionCode(code)
                .collectList()
                .flatMap(creditTransactions ->{
                    float[] a = {0};
                    creditTransactions.forEach(x->{
                       a[0] = a[0] + x.getAmount();
                    });
                    return Mono.just(a[0]);
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
