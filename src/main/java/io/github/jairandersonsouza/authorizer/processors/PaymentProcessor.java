package io.github.jairandersonsouza.authorizer.processors;

import io.github.jairandersonsouza.authorizer.entities.AccountBalance;
import io.github.jairandersonsouza.authorizer.entities.MccEnum;
import io.github.jairandersonsouza.authorizer.entities.Transaction;
import io.github.jairandersonsouza.authorizer.exceptions.TransactionRejectedException;
import io.github.jairandersonsouza.authorizer.repository.TrancasaoRe;
import io.github.jairandersonsouza.authorizer.repository.TransactionRepository;
import io.github.jairandersonsouza.authorizer.requests.TransactionInput;
import io.github.jairandersonsouza.authorizer.services.AccountBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public abstract class PaymentProcessor {

    @Autowired
    private AccountBalanceService accountBalanceService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TrancasaoRe trancasaoRe;

    //TODO
    //validar transactional
    @Transactional(propagation = Propagation.REQUIRED)
    public void startTransaction(TransactionInput transactionInput, AccountBalance account) {
        try {
            account.debit(transactionInput.getTotalAmount(), getMcc());
            this.accountBalanceService.save(account);
            var tran = new Transaction();
            tran.setId(UUID.randomUUID().toString());
            tran.setAccountId(transactionInput.getAccount());
            tran.setAmount(transactionInput.getTotalAmount());
            tran.setMerchant(transactionInput.getMerchant());
            tran.setMcc(transactionInput.getMcc());
//            this.transactionRepository.save(tran);
            trancasaoRe.insert(tran);
        } catch (TransactionRejectedException e) {
            throw e;
        }

    }

    public abstract MccEnum getMcc();
}
