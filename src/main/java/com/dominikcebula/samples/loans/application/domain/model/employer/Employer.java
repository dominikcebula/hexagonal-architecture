package com.dominikcebula.samples.loans.application.domain.model.employer;

import com.dominikcebula.samples.loans.application.domain.model.contact.Email;
import com.dominikcebula.samples.loans.application.domain.model.contact.PhoneNumber;
import com.dominikcebula.samples.loans.application.domain.model.contact.Website;
import com.dominikcebula.samples.loans.application.domain.model.identifier.Identifier;
import com.dominikcebula.samples.loans.application.domain.model.support.validation.Validation;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Employer {
    private Identifier identifier;
    private EmployerName name;
    private Industry industry;
    private Email email;
    private PhoneNumber phoneNumber;
    private Website website;

    public Employer(Identifier identifier, EmployerName name, Industry industry, Email email, PhoneNumber phoneNumber, Website website) {
        Validation.requireNonNull(identifier, "Identifier cannot be null.");
        Validation.requireNonNull(name, "Name cannot be null.");
        Validation.requireNonNull(industry, "Industry cannot be null.");
        Validation.requireNonNull(email, "Email cannot be null.");
        Validation.requireNonNull(phoneNumber, "PhoneNumber cannot be null.");
        Validation.requireNonNull(website, "Website cannot be null.");

        this.identifier = identifier;
        this.name = name;
        this.industry = industry;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.website = website;
    }
}
