package com.dominikcebula.samples.loans.application.domain.model.contact;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

@Getter
@EqualsAndHashCode
@ToString
public class Website {
    private static final Pattern WEBSITE_PATTERN = Pattern.compile("^(https?://)?([\\w.-]+)\\.([a-zA-Z]{2,})(:[0-9]{1,5})?(/.*)?$");

    private final String value;

    public Website(String value) {
        if (StringUtils.isEmpty(value))
            throw new IllegalArgumentException("Website value cannot be empty.");
        if (!WEBSITE_PATTERN.matcher(value).matches())
            throw new IllegalArgumentException("Website value is not a valid website.");
        this.value = value;
    }
}
