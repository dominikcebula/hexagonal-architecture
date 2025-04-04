package com.dominikcebula.samples.loans.application.domain.model.contact;

import com.dominikcebula.samples.loans.application.domain.model.support.DomainValidationException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

@Getter
@EqualsAndHashCode
@ToString
public class Email {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    private final String value;

    public Email(String value) {
        if (StringUtils.isBlank(value))
            throw new DomainValidationException("Email cannot be empty.");
        if (!EMAIL_PATTERN.matcher(value).matches())
            throw new DomainValidationException("Email value is not a valid email.");
        this.value = value;
    }
}
