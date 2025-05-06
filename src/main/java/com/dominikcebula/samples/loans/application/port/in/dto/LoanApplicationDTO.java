package com.dominikcebula.samples.loans.application.port.in.dto;

import com.dominikcebula.samples.loans.application.domain.model.loan.LoanStatus;

public record LoanApplicationDTO(int id, ApplicantDTO applicant, MoneyDTO amount, int termsInMonths,
                                 LoanStatus status) {
}
