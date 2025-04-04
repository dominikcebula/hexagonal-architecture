package com.dominikcebula.samples.loans.application.domain.model.loan;

import com.dominikcebula.samples.loans.application.domain.model.contact.Email;
import com.dominikcebula.samples.loans.application.domain.model.contact.PhoneNumber;
import com.dominikcebula.samples.loans.application.domain.model.person.BirthDate;
import com.dominikcebula.samples.loans.application.domain.model.person.FirstName;
import com.dominikcebula.samples.loans.application.domain.model.person.LastName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@EqualsAndHashCode
@ToString
public class Applicant {
    private final FirstName firstName;
    private final LastName lastName;
    private final BirthDate birthDate;
    private final Email email;
    private final PhoneNumber phoneNumber;

    public Applicant(FirstName firstName, LastName lastName, BirthDate birthDate, Email email, PhoneNumber phoneNumber) {
        Objects.requireNonNull(firstName, "First Name must not be null.");
        Objects.requireNonNull(lastName, "Last Name must not be null.");
        Objects.requireNonNull(birthDate, "Birth date must not be null.");
        Objects.requireNonNull(email, "Email must not be null.");
        Objects.requireNonNull(phoneNumber, "Phone number must not be null.");

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
