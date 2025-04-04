package com.dominikcebula.samples.loans.application.domain.model.employer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@Getter
@EqualsAndHashCode
@ToString
public class EmployerName {
    private final String value;

    public EmployerName(String value) {
        if (StringUtils.isBlank(value))
            throw new IllegalArgumentException("Employer name cannot be empty.");
        this.value = value;
    }
}
