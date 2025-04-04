package com.dominikcebula.samples.loans.application.domain.model.employer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@Getter
@EqualsAndHashCode
@ToString
public class Industry {
    private final String value;

    public Industry(String value) {
        if (StringUtils.isBlank(value))
            throw new IllegalArgumentException("Industry name cannot be empty.");
        this.value = value;
    }
}
