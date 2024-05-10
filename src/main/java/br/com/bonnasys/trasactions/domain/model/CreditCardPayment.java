package br.com.bonnasys.trasactions.domain.model;

public record CreditCardPayment(Double amount,
                                String orderId,
                                String token,
                                BillingAddress address) implements Payment {

    public CreditCardPayment {
        this.assertArgumentNotNull(amount, "'amount' must not be null");
        this.assertArgumentNotEmpty(orderId, "'orderId' must not be null");
        this.assertArgumentNotEmpty(token, "'token' must not be null");
        this.assertArgumentNotNull(address, "'address' must not be null");
    }

}
