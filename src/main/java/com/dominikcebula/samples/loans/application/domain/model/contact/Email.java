package com.dominikcebula.samples.loans.application.domain.model.contact;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@Getter
@EqualsAndHashCode
@ToString
public class Email {
    private final String value;

    public Email(String value) {
        if (StringUtils.isEmpty(value))
            throw new IllegalArgumentException("Email cannot be empty.");
        this.value = value;
    }
}
