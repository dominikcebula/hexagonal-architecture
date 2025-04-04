package com.dominikcebula.samples.loans.application.domain.model.employer;

import com.dominikcebula.samples.loans.application.domain.model.support.DomainValidationException;
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
            throw new DomainValidationException("Employer name cannot be empty.");
        this.value = value;
    }
}
