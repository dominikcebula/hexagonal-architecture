package com.dominikcebula.samples.loans.application.domain.model.person;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@EqualsAndHashCode
@ToString
public class BirthDate {
    private final LocalDate value;

    public BirthDate(LocalDate value) {
        Objects.requireNonNull(value, "Birth Date must not be null.");
        if (value.isBefore(LocalDate.now().minusYears(120)))
            throw new IllegalArgumentException("Birth Date must be within a reasonable period.");

        this.value = value;
    }
}
