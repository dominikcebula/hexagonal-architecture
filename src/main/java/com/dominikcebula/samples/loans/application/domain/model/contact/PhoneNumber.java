package com.dominikcebula.samples.loans.application.domain.model.contact;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@Getter
@EqualsAndHashCode
@ToString
public class PhoneNumber {
    private final String value;

    public PhoneNumber(String value) {
        if (StringUtils.isEmpty(value))
            throw new IllegalArgumentException("Phone number cannot be empty.");
        this.value = value;
    }
}
