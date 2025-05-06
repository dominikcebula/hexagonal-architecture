package com.dominikcebula.samples.loans.application.port.in.dto;

public class LoanApplicationRegistrationDTOBuilder {

    private ApplicantRegistrationDTO applicant = new ApplicantRegistrationDTOBuilder().build();
    private MoneyDTO amount = new MoneyDTOBuilder().build();
    private int termsInMonths = 36;

    public static LoanApplicationRegistrationDTOBuilder newLoanApplication() {
        return new LoanApplicationRegistrationDTOBuilder();
    }

    public LoanApplicationRegistrationDTOBuilder withApplicant(ApplicantRegistrationDTO applicant) {
        this.applicant = applicant;
        return this;
    }

    public LoanApplicationRegistrationDTOBuilder withAmount(MoneyDTO amount) {
        this.amount = amount;
        return this;
    }

    public LoanApplicationRegistrationDTOBuilder withTermsInMonths(int termsInMonths) {
        this.termsInMonths = termsInMonths;
        return this;
    }

    public LoanApplicationRegistrationDTO build() {
        return new LoanApplicationRegistrationDTO(applicant, amount, termsInMonths);
    }
}
