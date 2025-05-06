package com.dominikcebula.samples.loans.application.port.in.dto;

import java.math.BigDecimal;

public class MoneyDTOBuilder {

    private BigDecimal amount = BigDecimal.valueOf(10000);
    private String currency = "USD";

    public static MoneyDTOBuilder newMoney() {
        return new MoneyDTOBuilder();
    }

    public MoneyDTOBuilder withAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public MoneyDTOBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public MoneyDTO build() {
        return new MoneyDTO(amount, currency);
    }
}
