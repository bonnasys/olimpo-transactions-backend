package br.com.bonnasys.trasactions.domain.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static br.com.bonnasys.trasactions.domain.enums.PaymentState.CREATED;
import static br.com.bonnasys.trasactions.domain.enums.PaymentState.REFUNDED;

class PaymentStateTest {

    @Test
    void givenCreatedStateWhenCallsNextWithRefundedThenShouldAllow() {
        PaymentState expectedState = REFUNDED;

        PaymentState next = CREATED.next(expectedState);

        Assertions.assertEquals(expectedState, next);
    }

    @Test
    void givenCreatedStateWhenCallsNextWithFunctionWithRefundedThenShouldAllow() {
        PaymentState expectedState = REFUNDED;

        PaymentState next = CREATED.next(expectedState, () -> System.out.println("MEU AMIGO, ISSO AQUI TÁ REFUNDED!"));

        Assertions.assertEquals(expectedState, next);
    }

    @Test
    void givenCreatedStateWhenCallsNextWithCreatedThenShouldNotAllow() {
        var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> CREATED.next(CREATED));
        Assertions.assertEquals("Payment already created", exception.getMessage());
    }

}