package com.dominikcebula.samples.loans.application.domain.model.person;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Age {
    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 120;

    private final int value;

    public Age(int value) {
        if (value < MIN_AGE)
            throw new IllegalArgumentException("Age cannot be negative.");
        if (value > MAX_AGE)
            throw new IllegalArgumentException("Age cannot be greater than 120.");

        this.value = value;
    }
}
