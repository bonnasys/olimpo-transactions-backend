package br.com.bonnasys.trasactions.domain.model;

import br.com.bonnasys.trasactions.domain.enums.PaymentState;

public record PixPayment(Double amount,
                         String orderId,
                         BillingAddress address,
                         PaymentState state) implements Payment {
    public PixPayment {
        this.assertArgumentNotNull(amount, "'amount' should not be null");
        this.assertArgumentNotEmpty(orderId, "'orderId' should not be empty");
        this.assertArgumentNotNull(address, "'address' should not be null");
    }
}
