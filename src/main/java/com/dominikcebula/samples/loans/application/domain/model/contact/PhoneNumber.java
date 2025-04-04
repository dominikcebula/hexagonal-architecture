package com.dominikcebula.samples.loans.application.domain.model.contact;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

@Getter
@EqualsAndHashCode
@ToString
public class PhoneNumber {
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^\\+?[0-9]{1,4}?[-.\\s]?\\(?[0-9]{1,4}?\\)?[-.\\s]?[0-9]{1,4}[-.\\s]?[0-9]{1,9}(\\s?(ext|x|ext.)\\s?[0-9]{1,5})?$");

    private final String value;

    public PhoneNumber(String value) {
        if (StringUtils.isBlank(value))
            throw new IllegalArgumentException("Phone number cannot be empty.");
        if (!PHONE_NUMBER_PATTERN.matcher(value).matches())
            throw new IllegalArgumentException("Phone number value is not a valid website.");
        this.value = value;
    }
}
