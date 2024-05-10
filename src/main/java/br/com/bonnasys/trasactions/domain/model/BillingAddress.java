package br.com.bonnasys.trasactions.domain.model;

import br.com.bonnasys.trasactions.domain.AssertionConcern;

public record BillingAddress(String zipcode,
                             String number,
                             String complement,
                             String country) implements AssertionConcern {

    public BillingAddress {
        this.assertArgumentNotEmpty(zipcode, "'zipcode' should not be null or blank");
        this.assertArgumentNotEmpty(number, "'number' should not be null or blank");
        this.assertArgumentNotEmpty(complement, "'complement' should not be null or blank");
        this.assertArgumentNotEmpty(country, "'country' should not be null or blank");
    }
}
