package com.dominikcebula.samples.loans.application.domain.model.employer;

import com.dominikcebula.samples.loans.application.domain.model.contact.Email;
import com.dominikcebula.samples.loans.application.domain.model.contact.PhoneNumber;
import com.dominikcebula.samples.loans.application.domain.model.contact.Website;
import com.dominikcebula.samples.loans.application.domain.model.identifier.Identifier;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

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
        Objects.requireNonNull(identifier, "Identifier cannot be null.");
        Objects.requireNonNull(name, "Name cannot be null.");
        Objects.requireNonNull(industry, "Industry cannot be null.");
        Objects.requireNonNull(email, "Email cannot be null.");
        Objects.requireNonNull(phoneNumber, "PhoneNumber cannot be null.");
        Objects.requireNonNull(website, "Website cannot be null.");

        this.identifier = identifier;
        this.name = name;
        this.industry = industry;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.website = website;
    }
}
