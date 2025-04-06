package com.dominikcebula.samples.loans.application.port.in;

import com.dominikcebula.samples.loans.application.port.in.dto.LoanApplicationDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Optional;

import static com.dominikcebula.samples.loans.application.port.in.ApproveLoanUseCase.LoanApprovalAnswerStatus.APPROVED;
import static com.dominikcebula.samples.loans.application.port.in.ApproveLoanUseCase.LoanApprovalAnswerStatus.NOT_FOUND;

public interface ApproveLoanUseCase {
    LoanApprovalAnswer approveLoan(int id);

    @Getter
    @EqualsAndHashCode
    @ToString
    class LoanApprovalAnswer {
        private final LoanApprovalAnswerStatus status;
        private LoanApplicationDTO loanApplication;

        private LoanApprovalAnswer(LoanApprovalAnswerStatus status) {
            this.status = status;
        }

        public LoanApprovalAnswer(LoanApprovalAnswerStatus status, LoanApplicationDTO loanApplication) {
            this.status = status;
            this.loanApplication = loanApplication;
        }

        public Optional<LoanApplicationDTO> getLoanApplication() {
            return Optional.ofNullable(loanApplication);
        }

        public static LoanApprovalAnswer approved(LoanApplicationDTO loanApplicationDTO) {
            return new LoanApprovalAnswer(APPROVED, loanApplicationDTO);
        }

        public static LoanApprovalAnswer loanNotFound() {
            return new LoanApprovalAnswer(NOT_FOUND);
        }
    }

    enum LoanApprovalAnswerStatus {
        APPROVED,
        REJECTED,
        NOT_FOUND
    }
}
