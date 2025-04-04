package com.dominikcebula.samples.loans.application.domain.model.employer;

import com.dominikcebula.samples.loans.application.domain.model.contact.Email;
import com.dominikcebula.samples.loans.application.domain.model.contact.PhoneNumber;
import com.dominikcebula.samples.loans.application.domain.model.identifier.Identifier;

public class Employer {
    private Identifier identifier;
    private String name;
    private String industry;
    private Email email;
    private PhoneNumber phoneNumber;
    private String website;
}
