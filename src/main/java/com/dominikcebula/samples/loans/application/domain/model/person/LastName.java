package com.dominikcebula.samples.loans.application.domain.model.person;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@Getter
@EqualsAndHashCode
@ToString
public class LastName {
    private final String value;

    public LastName(String value) {
        if (StringUtils.isEmpty(value))
            throw new IllegalArgumentException("Last Name cannot be empty.");
        this.value = value;
    }
}
