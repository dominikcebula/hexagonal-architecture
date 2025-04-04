package com.dominikcebula.samples.loans.application.domain.model.person;

import com.dominikcebula.samples.loans.application.domain.model.support.DomainValidationException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@Getter
@EqualsAndHashCode
@ToString
public class FirstName {
    private final String value;

    public FirstName(String value) {
        if (StringUtils.isBlank(value))
            throw new DomainValidationException("First Name cannot be empty.");
        this.value = value;
    }
}
