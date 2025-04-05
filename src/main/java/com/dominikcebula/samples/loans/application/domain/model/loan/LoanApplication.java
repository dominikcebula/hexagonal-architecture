package com.dominikcebula.samples.loans.application.domain.model.loan;

import com.dominikcebula.samples.loans.application.domain.model.identifier.Identifier;
import com.dominikcebula.samples.loans.application.domain.model.support.validation.DomainValidationException;
import com.dominikcebula.samples.loans.application.domain.model.support.validation.Validation;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.javamoney.moneta.Money;

import static com.dominikcebula.samples.loans.application.domain.model.loan.LoanStatus.APPROVED;

@Getter
@EqualsAndHashCode
@ToString
public class LoanApplication {
    private final Identifier identifier;
    private final Applicant applicant;
    private final LoanAmount amount;
    private final TermsInMonths termsInMonths;
    private LoanStatus status;

    public LoanApplication(Applicant applicant, LoanAmount amount, TermsInMonths termsInMonths) {
        this(Identifier.empty(), applicant, amount, termsInMonths, LoanStatus.REGISTERED);
    }

    public LoanApplication(Identifier identifier, Applicant applicant, LoanAmount amount, TermsInMonths termsInMonths, LoanStatus status) {
        Validation.requireNonNull(identifier, "identifier is required.");
        Validation.requireNonNull(applicant, "applicant is required.");
        Validation.requireNonNull(amount, "amount is required.");
        Validation.requireNonNull(termsInMonths, "term in months is required.");
        Validation.requireNonNull(status, "status is required.");

        this.identifier = identifier;
        this.applicant = applicant;
        this.amount = amount;
        this.termsInMonths = termsInMonths;
        this.status = status;
    }

    public void approve() {
        validateLoanCanBeApproved();

        status = APPROVED;
    }

    private void validateLoanCanBeApproved() {
        validateIsOfLegalAge();
        validateHasSufficientCreditScore();
        validateHasStableEmployment();
        validateHasSufficientIncome();
    }

    private void validateIsOfLegalAge() {
        if (!applicant.getAge().isAdult())
            throw new DomainValidationException("Applicant is not of legal age.");
    }

    private void validateHasSufficientCreditScore() {
        if (applicant.getCreditScore().getValue() < 600)
            throw new DomainValidationException("Applicant does not has sufficient credit score.");
    }

    private void validateHasStableEmployment() {
        if (!applicant.getEmployment().isStableEmployer())
            throw new DomainValidationException("Applicant does not have stable employer.");
    }

    private void validateHasSufficientIncome() {
        Money monthlyLoanPayment = calculateSimplifiedMonthlyPayment();
        Money loanPaymentsForOneQuarter = monthlyLoanPayment.multiply(3);

        if (applicant.getEmployment().getYearlyIncome().isLessThan(loanPaymentsForOneQuarter))
            throw new DomainValidationException("Applicant does not have sufficient income for a loan.");
    }

    private Money calculateSimplifiedMonthlyPayment() {
        return amount.getValue().divide(termsInMonths.getValue());
    }
}
