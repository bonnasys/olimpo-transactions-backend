package br.com.bonnasys.trasactions.domain.model;

import br.com.bonnasys.trasactions.domain.AssertionConcern;
import br.com.bonnasys.trasactions.domain.enums.PaymentState;

import static br.com.bonnasys.trasactions.domain.enums.PaymentState.CREATED;

public sealed interface Payment
        extends AssertionConcern
        permits PixPayment, CreditCardPayment {
    String PIX = "pix";
    String CREDIT_CARD = "credit_card";

    Double amount();
    String orderId();
    BillingAddress address();
    PaymentState state();

    static Payment create(final String type,
                          final String orderId,
                          final Double amount,
                          final BillingAddress address,
                          final String token) {
        return switch (type) {
            case PIX -> new PixPayment(amount, orderId, address, CREATED);
            case CREDIT_CARD -> new CreditCardPayment(amount, orderId, token, address, CREATED);
            default -> throw new IllegalArgumentException("Unsupported payment type: " + type);
        };
    }

    static Payment create(final String type,
                          final String orderId,
                          final Double amount,
                          final BillingAddress address) {
        return create(type, orderId, amount, address, null);
    }
}
