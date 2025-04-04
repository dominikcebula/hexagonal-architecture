package com.dominikcebula.samples.loans.application.domain.model.identifier;

import com.dominikcebula.samples.loans.application.domain.model.support.DomainValidationException;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Optional;

@EqualsAndHashCode
@ToString
public class Identifier {
    private Integer value;

    public Identifier(int value) {
        if (value < 0)
            throw new DomainValidationException("Identifier value cannot be negative.");
        this.value = value;
    }

    Identifier() {
    }

    public static Identifier empty() {
        return new Identifier();
    }

    public Optional<Integer> getValue() {
        return Optional.ofNullable(value);
    }
}
