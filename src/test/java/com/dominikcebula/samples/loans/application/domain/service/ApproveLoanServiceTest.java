package com.dominikcebula.samples.loans.application.domain.service;

import com.dominikcebula.samples.loans.application.domain.model.loan.LoanStatus;
import com.dominikcebula.samples.loans.application.port.in.ApproveLoanUseCase;
import com.dominikcebula.samples.loans.application.port.in.ApproveLoanUseCase.LoanApprovalAnswerStatus;
import com.dominikcebula.samples.loans.application.port.in.LoanTestUtils;
import com.dominikcebula.samples.loans.application.port.in.dto.LoanApplicationDTO;
import com.dominikcebula.samples.loans.application.port.in.dto.mapper.LoanApplicationMapper;
import com.dominikcebula.samples.loans.application.port.out.persistence.LoanApplicationRepository;
import com.dominikcebula.samples.loans.test.support.UseCaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import static com.dominikcebula.samples.loans.application.port.in.ApproveLoanUseCase.LoanApprovalAnswer;
import static org.assertj.core.api.Assertions.assertThat;

@UseCaseTest
class ApproveLoanServiceTest {
    @Autowired
    private LoanTestUtils loanTestUtils;
    @Autowired
    private ApproveLoanUseCase approveLoanUseCase;
    @Autowired
    private LoanApplicationRepository repository;
    @Autowired
    private LoanApplicationMapper mapper;

    @Test
    @DirtiesContext
    void shouldApproveLoan() {
        // given
        LoanApplicationDTO loanApplicationDTO = loanTestUtils.registerLoanApplication();

        // when
        LoanApprovalAnswer loanApprovalAnswer = approveLoanUseCase.approveLoan(loanApplicationDTO.id());

        // then
        assertThat(loanApprovalAnswer.getStatus()).isEqualTo(LoanApprovalAnswerStatus.APPROVED);
        assertThat(loanApprovalAnswer.getValidationErrorMessages()).isEmpty();
        assertThat(loanApprovalAnswer.getLoanApplication().isPresent()).isTrue();
        assertThat(loanApprovalAnswer.getLoanApplication().get())
                .usingRecursiveComparison()
                .ignoringFields("status")
                .isEqualTo(loanApplicationDTO);
        assertThat(loanApprovalAnswer.getLoanApplication().get().status())
                .isEqualTo(LoanStatus.APPROVED);
        assertThat(loanApplicationDTO.status())
                .isEqualTo(LoanStatus.REGISTERED);
        assertThat(loanApprovalAnswer.getLoanApplication().get())
                .isEqualTo(mapper.loanApplicationToLoanApplicationDTO(repository.findById(loanApplicationDTO.id()).orElseThrow()));
    }
}
