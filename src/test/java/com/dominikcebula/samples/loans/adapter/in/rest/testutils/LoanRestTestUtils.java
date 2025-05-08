package com.dominikcebula.samples.loans.adapter.in.rest.testutils;

import com.dominikcebula.samples.loans.application.port.in.dto.LoanApplicationDTO;
import com.dominikcebula.samples.loans.application.port.in.dto.LoanApplicationRegistrationDTO;
import com.dominikcebula.samples.loans.application.port.in.dto.builder.ApplicantRegistrationDTOBuilder;
import com.dominikcebula.samples.loans.application.port.in.dto.builder.EmploymentRegistrationDTOBuilder;
import com.dominikcebula.samples.loans.application.port.in.dto.builder.MoneyDTOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static com.dominikcebula.samples.loans.adapter.in.rest.ApiConstants.API_BASE;
import static com.dominikcebula.samples.loans.application.port.in.dto.builder.LoanApplicationRegistrationDTOBuilder.newLoanApplication;
import static org.assertj.core.api.Assertions.assertThat;

@Component
public class LoanRestTestUtils {
    @Autowired
    private TestRestTemplate testRestTemplate;

    public List<LoanApplicationDTO> registerLoanApplications() {
        List<LoanApplicationRegistrationDTO> loanApplicationRegistrations = createLoanApplicationRegistrations();

        List<ResponseEntity<LoanApplicationDTO>> responses = loanApplicationRegistrations.stream()
                .map(registrationDTO -> testRestTemplate.postForEntity(API_BASE, registrationDTO, LoanApplicationDTO.class))
                .toList();

        assertThat(responses).hasSize(loanApplicationRegistrations.size());
        assertThat(responses).extracting(ResponseEntity::getStatusCode).allMatch(HttpStatus.CREATED::equals);

        return responses.stream()
                .map(ResponseEntity::getBody)
                .toList();
    }

    private List<LoanApplicationRegistrationDTO> createLoanApplicationRegistrations() {
        return List.of(
                newLoanApplication()
                        .withApplicant(
                                ApplicantRegistrationDTOBuilder
                                        .newApplicant()
                                        .withEmail("John.Doe@mail.com")
                                        .withFirstName("John")
                                        .withLastName("Doe")
                                        .withCreditScore(100)
                                        .withBirthDate(LocalDate.of(1985, Month.FEBRUARY, 11))
                                        .withEmployment(
                                                EmploymentRegistrationDTOBuilder
                                                        .newEmployment()
                                                        .withName("TechNova Solutions")
                                                        .withIndustry("Information Technology")
                                                        .withWebsite("https://www.technova.com")
                                                        .withEmail("contact@technova.com")
                                                        .withYearlyIncome(MoneyDTOBuilder.newMoney()
                                                                .withAmount(12500000)
                                                                .build())
                                                        .withNumberOfEmployees(240)
                                                        .build())
                                        .build())
                        .withAmount(MoneyDTOBuilder.newMoney()
                                .withAmount(10000)
                                .build())
                        .withTermsInMonths(10)
                        .build(),
                newLoanApplication()
                        .withApplicant(
                                ApplicantRegistrationDTOBuilder
                                        .newApplicant()
                                        .withEmail("Emily.Carter@mail.com")
                                        .withFirstName("Emily")
                                        .withLastName("Carter")
                                        .withCreditScore(200)
                                        .withBirthDate(LocalDate.of(1983, Month.APRIL, 15))
                                        .withEmployment(
                                                EmploymentRegistrationDTOBuilder
                                                        .newEmployment()
                                                        .withName("GreenField Logistics")
                                                        .withIndustry("Transportation and Logistics")
                                                        .withWebsite("https://www.greenfieldlogistics.com")
                                                        .withEmail("info@greenfieldlogistics.com")
                                                        .withYearlyIncome(MoneyDTOBuilder.newMoney()
                                                                .withAmount(8700000)
                                                                .build())
                                                        .withNumberOfEmployees(150)
                                                        .build())
                                        .build())
                        .withAmount(MoneyDTOBuilder.newMoney()
                                .withAmount(20000)
                                .build())
                        .withTermsInMonths(20)
                        .build(),
                newLoanApplication()
                        .withApplicant(
                                ApplicantRegistrationDTOBuilder
                                        .newApplicant()
                                        .withEmail("James.Morgan@example.com")
                                        .withFirstName("James")
                                        .withLastName("Morgan")
                                        .withCreditScore(720)
                                        .withBirthDate(LocalDate.of(1990, Month.DECEMBER, 5))
                                        .withEmployment(
                                                EmploymentRegistrationDTOBuilder
                                                        .newEmployment()
                                                        .withName("Aurum Financial Group")
                                                        .withIndustry("Financial Services")
                                                        .withWebsite("https://www.aurumfinance.com")
                                                        .withEmail("support@aurumfinance.com")
                                                        .withYearlyIncome(MoneyDTOBuilder.newMoney()
                                                                .withAmount(19800000)
                                                                .build())
                                                        .withNumberOfEmployees(320)
                                                        .build())
                                        .build())
                        .withAmount(MoneyDTOBuilder.newMoney()
                                .withAmount(50000)
                                .build())
                        .withTermsInMonths(36)
                        .build());
    }
}
