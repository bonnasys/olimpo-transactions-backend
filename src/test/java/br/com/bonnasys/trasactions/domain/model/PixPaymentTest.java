package br.com.bonnasys.trasactions.domain.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static br.com.bonnasys.trasactions.domain.enums.PaymentState.CREATED;

class PixPaymentTest {

    @Test
    void givenAllParamsWhenCallsPaymentCreateThenAssertInstanceOfAndFields() {
        Double amount = 100.0;
        String orderId = "123";
        String zipCode = "13156-876";
        String number = "92";
        String complement = "Casa 2";
        String country = "BR";
        BillingAddress address = new BillingAddress(zipCode, number, complement, country);

        Payment actualPayment = Payment.create(Payment.PIX, orderId, amount, address);

        Assertions.assertInstanceOf(PixPayment.class, actualPayment);

        Assertions.assertEquals(CREATED, actualPayment.state());
        Assertions.assertEquals(amount, actualPayment.amount());
        Assertions.assertEquals(orderId, actualPayment.orderId());
        Assertions.assertEquals(address, actualPayment.address());
    }

    @Test
    void givenInvalidPaymentTypeWhenCallsPaymentCreateThenThrowsException() {
        Double amount = 100.0;
        String orderId = "123";
        String zipCode = "13156-876";
        String number = "92";
        String complement = "Casa 2";
        String country = "BR";
        BillingAddress address = new BillingAddress(zipCode, number, complement, country);


        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Payment.create("transacao_tabajara", orderId, amount, address));
    }
}