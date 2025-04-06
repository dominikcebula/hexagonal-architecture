package com.dominikcebula.samples.loans.application.port.in.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class EmploymentDTO {
    private final int id;
    private final String name;
    private final String industry;
    private final MoneyDTO yearlyIncome;
    private final int numberOfEmployees;
    private final String email;
    private final String phoneNumber;
    private final String website;
}
