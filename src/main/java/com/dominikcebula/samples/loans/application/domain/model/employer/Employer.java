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
    private final Identifier identifier;
    private final EmployerName name;
    private final Industry industry;
    private final NumberOfEmployees numberOfEmployees;
    private final Email email;
    private final PhoneNumber phoneNumber;
    private final Website website;

    public Employer(Identifier identifier, EmployerName name, Industry industry, NumberOfEmployees numberOfEmployees, Email email, PhoneNumber phoneNumber, Website website) {
        Validation.requireNonNull(identifier, "Identifier cannot be null.");
        Validation.requireNonNull(name, "Name cannot be null.");
        Validation.requireNonNull(industry, "Industry cannot be null.");
        Validation.requireNonNull(numberOfEmployees, "Number of employees cannot be null.");
        Validation.requireNonNull(email, "Email cannot be null.");
        Validation.requireNonNull(phoneNumber, "PhoneNumber cannot be null.");
        Validation.requireNonNull(website, "Website cannot be null.");

        this.identifier = identifier;
        this.name = name;
        this.industry = industry;
        this.numberOfEmployees = numberOfEmployees;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.website = website;
    }
}
