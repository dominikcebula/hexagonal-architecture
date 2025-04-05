package com.dominikcebula.samples.loans.application.port.in.dto;

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
    private final ApplicantRegistrationDTO applicant;
    private final MoneyDTO amount;
    private final int termsInMonths;
}
