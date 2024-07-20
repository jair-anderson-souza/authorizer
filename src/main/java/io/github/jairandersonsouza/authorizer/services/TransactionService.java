
package io.github.jairandersonsouza.authorizer.services;

import io.github.jairandersonsouza.authorizer.requests.TransactionInput;
import io.github.jairandersonsouza.authorizer.template.PaymentFactory;
import io.github.jairandersonsouza.authorizer.template.PaymentProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TransactionService {

//    @Autowired
//    private TransactionValidation transactionValidation;

    @Autowired
    private AccountService accountService;

    @Autowired
    private Map<String, PaymentProcessor> adapters;

    @Autowired
    private PaymentFactory paymentFactory;

    public void transact(TransactionInput transactionInput) {
//        this.valid(transactionInput);
        final var account = this.accountService.getAccount(transactionInput.getAccount(), transactionInput.getTotalAmount());
        final var paymentProcessor = this.paymentFactory.getProcessor(transactionInput, account);
//        paymentProcessor.processTransaction(transactionInput);
    }

//    public void valid(TransactionInput transactionInput) {
//        final var account = this.accountService.getAccount(transactionInput.getAccount(), transactionInput.getTotalAmount());
//        //verificar se tem saldo
//        //verificar o tipo
//
//        //se der true, significa que a validação é correta
//        if (account.validTransaction(transactionInput)) {
//            final var paymentProcessor = this.paymentProcessorFactory.getProcessor(transactionInput);
//            paymentProcessor.processTransaction(transactionInput);
//        }
//
////        false significa que preciso validar agora só no CASH
////        account.va;
//
//
//
//
//
//
//
//    }
}
