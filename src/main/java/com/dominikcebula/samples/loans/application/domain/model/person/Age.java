package com.dominikcebula.samples.loans.application.domain.model.person;

import com.dominikcebula.samples.loans.application.domain.model.support.DomainValidationException;
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
            throw new DomainValidationException("Age cannot be negative.");
        if (value > MAX_AGE)
            throw new DomainValidationException("Age cannot be greater than 120.");

        this.value = value;
    }
}
