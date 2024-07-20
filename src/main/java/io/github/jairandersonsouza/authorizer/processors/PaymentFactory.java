package io.github.jairandersonsouza.authorizer.processors;

import io.github.jairandersonsouza.authorizer.entities.AccountBalance;
import io.github.jairandersonsouza.authorizer.entities.MccEnum;
import io.github.jairandersonsouza.authorizer.requests.TransactionInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentFactory {

    @Autowired
    private Map<String, PaymentProcessor> targets;

    public PaymentProcessor getProcessor(TransactionInput transactionInput, AccountBalance account) {
        //TODO
        //fazer aqui a validação do account
        //1. verifica logo limite de saldo, se não houver, retorna CASH
        //2. verifica logo se o mmc é algo aleatório, se for retorn CASH
        //3. valida o MMC e retorna o PaymentProcessor Correspondente
//        if (operationIsCash(account, transactionInput) || (!operationIsMeal(account, transactionInput) && !operationIsFood(account, transactionInput))) {
//            return this.targets.get(MccEnum.CASH.name());
//        } else
        if (isMealOperationValid(account, transactionInput)) {
            return this.targets.get(MccEnum.MEAL.name());
        } else if (isFoodOperationValid(account, transactionInput)) {
            return this.targets.get(MccEnum.FOOD.name());
        } else {
            return this.targets.get(MccEnum.CASH.name());
        }

    }

//    boolean operationIsCash(Account account, TransactionInput transactionInput) {
//        return (!operationIsMeal(account, transactionInput) && !operationIsMeal(account, transactionInput)) && account.amountGteThan(transactionInput, MccEnum.MEAL);
//    }

    boolean isMealOperationValid(AccountBalance account, TransactionInput transactionInput) {
        return isMeal(transactionInput) && account.amountGteThan(transactionInput);
    }

    public  boolean isMeal(TransactionInput transactionInput) {
        return transactionInput.getMcc().equals("5811") || transactionInput.getMcc().equals("5812");
    }

    boolean isFoodOperationValid(AccountBalance account, TransactionInput transactionInput) {
        return isFood(transactionInput) && account.amountGteThan(transactionInput);
    }

    public boolean isFood(TransactionInput transactionInput) {
        return transactionInput.getMcc().equals("5411") || transactionInput.getMcc().equals("5412");
    }


}
