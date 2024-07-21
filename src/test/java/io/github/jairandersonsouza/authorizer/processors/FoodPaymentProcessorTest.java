package io.github.jairandersonsouza.authorizer.processors;

import io.github.jairandersonsouza.authorizer.entities.MccEnum;
import io.github.jairandersonsouza.authorizer.requests.TransactionInput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;

import static io.github.jairandersonsouza.authorizer.entities.MccEnum.CASH;
import static io.github.jairandersonsouza.authorizer.entities.MccEnum.FOOD;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FoodPaymentProcessorTest {

    @InjectMocks
    private FoodTransactionProcessor foodTransactionProcessor;


    @Test
    void testShouldGetMcc() {
        MccEnum mcc = this.foodTransactionProcessor.getMcc("2345");
        assertEquals(FOOD, mcc);

    }


}