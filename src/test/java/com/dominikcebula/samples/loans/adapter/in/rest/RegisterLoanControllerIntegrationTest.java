package com.dominikcebula.samples.loans.adapter.in.rest;

import com.dominikcebula.samples.loans.adapter.out.persistence.PostgreSQLContainerConfiguration;
import com.dominikcebula.samples.loans.application.port.in.dto.LoanApplicationDTO;
import com.dominikcebula.samples.loans.application.port.in.dto.LoanApplicationRegistrationDTO;
import com.dominikcebula.samples.loans.application.port.in.dto.assertions.LoanApplicationDTOAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static com.dominikcebula.samples.loans.adapter.in.rest.ApiConstants.API_BASE;
import static com.dominikcebula.samples.loans.application.port.in.dto.builder.LoanApplicationRegistrationDTOBuilder.newLoanApplication;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpHeaders.LOCATION;
import static org.springframework.http.HttpStatus.CREATED;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Testcontainers
@Import({PostgreSQLContainerConfiguration.class})
class RegisterLoanControllerIntegrationTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @DirtiesContext
    void shouldRegisterLoan() {
        // given
        LoanApplicationRegistrationDTO applicationRegistrationDTO = newLoanApplication().build();

        // when
        ResponseEntity<LoanApplicationDTO> response = testRestTemplate.postForEntity(API_BASE, applicationRegistrationDTO, LoanApplicationDTO.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(CREATED);
        assertThat(response.getHeaders())
                .containsEntry(LOCATION, List.of(API_BASE + "/" + response.getBody().id()));
        LoanApplicationDTOAssertions.assertEquals(response.getBody(), applicationRegistrationDTO);
    }
}
