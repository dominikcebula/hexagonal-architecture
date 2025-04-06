package com.dominikcebula.samples.loans.application.port.in.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class ApplicantDTO {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final int creditScore;
    private final EmploymentDTO employment;
    private final String email;
    private final String phoneNumber;
}
