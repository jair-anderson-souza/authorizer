package io.github.jairandersonsouza.authorizer.processors;

import io.github.jairandersonsouza.authorizer.entities.AccountBalance;
import io.github.jairandersonsouza.authorizer.entities.MccEnum;
import io.github.jairandersonsouza.authorizer.repository.TransactionRepository;
import io.github.jairandersonsouza.authorizer.requests.TransactionInput;
import io.github.jairandersonsouza.authorizer.services.AccountBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("MEAL")
public class MealPaymentProcessor extends PaymentProcessor {

    @Autowired
    private AccountBalanceService accountBalanceService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void startTransaction(TransactionInput transactionInput, AccountBalance account) {
        super.startTransaction(transactionInput, account);
    }

    @Override
    public MccEnum getMcc() {
        return MccEnum.MEAL;
    }


}
