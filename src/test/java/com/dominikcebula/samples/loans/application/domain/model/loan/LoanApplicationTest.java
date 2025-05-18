package com.dominikcebula.samples.loans.application.domain.model.loan;

import com.dominikcebula.samples.loans.application.port.in.dto.builder.LoanApplicationBuilder;
import com.dominikcebula.samples.loans.application.port.time.MockDateProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.dominikcebula.samples.loans.application.domain.model.loan.LoanApplication.LoanApprovalResult;
import static com.dominikcebula.samples.loans.application.domain.model.loan.LoanStatus.APPROVED;
import static org.assertj.core.api.Assertions.assertThat;

class LoanApplicationTest {
    @BeforeEach
    public void setUp() {
        MockDateProvider.setUp();
    }

    @AfterEach
    public void tearDown() {
        MockDateProvider.tearDown();
    }

    @Test
    void shouldApproveLoan() {
        // given
        LoanApplication loanApplication = LoanApplicationBuilder.newLoanApplication().build();

        // when
        LoanApprovalResult approvalResult = loanApplication.approve();

        // then
        assertThat(loanApplication.getStatus()).isEqualTo(APPROVED);
        assertThat(approvalResult.getStatus()).isEqualTo(APPROVED);
        assertThat(approvalResult.getValidationResults().isSuccessful()).isTrue();
        assertThat(approvalResult.getValidationResults().getMessages()).isEmpty();
    }
}
