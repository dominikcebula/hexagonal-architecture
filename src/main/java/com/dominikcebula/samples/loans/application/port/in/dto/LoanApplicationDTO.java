package com.dominikcebula.samples.loans.application.port.in.dto;

import com.dominikcebula.samples.loans.application.domain.model.loan.LoanStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class LoanApplicationDTO {
    private final int id;
    private final ApplicantDTO applicant;
    private final MoneyDTO amount;
    private final int termsInMonths;
    private final LoanStatus status;
}
