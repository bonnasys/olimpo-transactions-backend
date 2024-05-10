package br.com.bonnasys.trasactions.domain.model;

import br.com.bonnasys.trasactions.domain.AssertionConcern;

public sealed interface Payment
        extends AssertionConcern
        permits PixPayment, CreditCardPayment {
    String PIX = "pix";
    String CREDIT_CARD = "credit_card";

    Double amount();
    String orderId();
    BillingAddress address();


    static Payment create(final String type,
                          final String orderId,
                          final Double amount,
                          final BillingAddress address,
                          final String token) {
        return switch (type) {
            case PIX -> new PixPayment(amount, orderId, address);
            case CREDIT_CARD -> new CreditCardPayment(amount, orderId, token, address);
            default -> throw new IllegalArgumentException("Unsupported payment type: " + type);
        };
    }
}
