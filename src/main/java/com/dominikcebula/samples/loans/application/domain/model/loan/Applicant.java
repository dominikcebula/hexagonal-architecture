package com.dominikcebula.samples.loans.application.domain.model.loan;

import com.dominikcebula.samples.loans.application.domain.model.contact.Email;
import com.dominikcebula.samples.loans.application.domain.model.contact.PhoneNumber;
import com.dominikcebula.samples.loans.application.domain.model.identifier.Identifier;
import com.dominikcebula.samples.loans.application.domain.model.person.BirthDate;
import com.dominikcebula.samples.loans.application.domain.model.person.FirstName;
import com.dominikcebula.samples.loans.application.domain.model.person.LastName;
import com.dominikcebula.samples.loans.application.domain.model.support.validation.Validation;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Applicant {
    private final Identifier identifier = Identifier.empty();
    private final FirstName firstName;
    private final LastName lastName;
    private final BirthDate birthDate;
    private final Email email;
    private final PhoneNumber phoneNumber;

    public Applicant(FirstName firstName, LastName lastName, BirthDate birthDate, Email email, PhoneNumber phoneNumber) {
        Validation.requireNonNull(firstName, "First Name must not be null.");
        Validation.requireNonNull(lastName, "Last Name must not be null.");
        Validation.requireNonNull(birthDate, "Birth date must not be null.");
        Validation.requireNonNull(email, "Email must not be null.");
        Validation.requireNonNull(phoneNumber, "Phone number must not be null.");

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
