package com.dominikcebula.samples.loans.application.domain.model.loan;

import com.dominikcebula.samples.loans.application.domain.model.identifier.Identifier;
import com.dominikcebula.samples.loans.application.domain.model.support.validation.Validation;

import static com.dominikcebula.samples.loans.application.domain.model.loan.LoanStatus.APPROVED;

public class LoanApplication {
    private final Identifier identifier;
    private final Applicant applicant;
    private final LoanAmount amount;
    private LoanStatus status;

    public LoanApplication(Applicant applicant, LoanAmount amount) {
        this(Identifier.empty(), applicant, amount, LoanStatus.REGISTERED);
    }

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

    public void approve() {
        validateLoanCanBeApproved();

        status = APPROVED;
    }

    private void validateLoanCanBeApproved() {

    }
}
