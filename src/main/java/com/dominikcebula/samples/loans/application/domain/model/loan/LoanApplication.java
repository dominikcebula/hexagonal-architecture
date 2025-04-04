package com.dominikcebula.samples.loans.application.domain.model.loan;

import com.dominikcebula.samples.loans.application.domain.model.identifier.Identifier;
import com.dominikcebula.samples.loans.application.domain.model.support.validation.Validation;

public class LoanApplication {
    private final Identifier identifier;
    private final Applicant applicant;
    private final LoanAmount amount;
    private final LoanStatus status;

    public LoanApplication(Identifier identifier, Applicant applicant, LoanAmount amount, LoanStatus status) {
        Validation.requireNonNull(identifier, "identifier is required.");
        Validation.requireNonNull(applicant, "applicant is required.");
        Validation.requireNonNull(amount, "amount is required.");
        Validation.requireNonNull(status, "status is required.");

        this.identifier = identifier;
        this.applicant = applicant;
        this.amount = amount;
        this.status = status;
    }
}
