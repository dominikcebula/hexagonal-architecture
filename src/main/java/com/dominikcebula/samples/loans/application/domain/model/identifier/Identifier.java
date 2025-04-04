package com.dominikcebula.samples.loans.application.domain.model.identifier;

import com.dominikcebula.samples.loans.application.domain.model.support.validation.Validation;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Optional;

@Getter
@EqualsAndHashCode
@ToString
public class Identifier {
    private Integer value;

    public Identifier(int value) {
        Validation.requireValueMatchingCondition(value > 0, "Employer name cannot be negative.");
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
