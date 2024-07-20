package io.github.jairandersonsouza.authorizer.processors;

import io.github.jairandersonsouza.authorizer.entities.AccountBalance;
import io.github.jairandersonsouza.authorizer.entities.MccEnum;
import io.github.jairandersonsouza.authorizer.repository.TransactionRepository;
import io.github.jairandersonsouza.authorizer.requests.TransactionInput;
import io.github.jairandersonsouza.authorizer.services.AccountBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("FOOD")
public class FoodPaymentProcessor extends PaymentProcessor {


    @Autowired
    private AccountBalanceService accountBalanceService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void startTransaction(TransactionInput transactionInput, AccountBalance account) {
        super.startTransaction(transactionInput, account);
    }

    //    @Transactional
//    @Override
//    public void startTransaction(TransactionInput transactionInput) {
//        try {
//
//
//            final var account = this.accountService.getAccount(transactionInput.getAccount(), transactionInput.getTotalAmount());
//            account.debit(transactionInput.getTotalAmount(), getMcc());
//
//            this.accountService.save(account);
//            var tran = new Transaction();
//            tran.setId(UUID.randomUUID().toString());
//            tran.setAccountId(transactionInput.getAccount());
//            tran.setAmount(transactionInput.getTotalAmount());
//            tran.setMerchant(transactionInput.getMerchant());
//            tran.setMcc(transactionInput.getMcc());
//            this.transactionRepository.save(tran);
//        } catch (TransactionRejectedException e) {
//            throw e;
//        }
//
//    }

    @Override
    public MccEnum getMcc() {
        return MccEnum.FOOD;
    }

}
