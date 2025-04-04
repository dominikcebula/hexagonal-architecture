package com.dominikcebula.samples.loans.application.domain.model.person;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Age {
    private final int value;

    public Age(int value) {
        if (value < 0)
            throw new IllegalArgumentException("Age cannot be negative.");
        if (value > 120)
            throw new IllegalArgumentException("Age cannot be greater than 120.");

        this.value = value;
    }
}
