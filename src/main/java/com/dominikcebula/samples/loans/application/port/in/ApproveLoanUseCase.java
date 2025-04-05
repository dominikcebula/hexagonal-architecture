package com.dominikcebula.samples.loans.application.port.in;

import com.dominikcebula.samples.loans.application.port.in.dto.LoanApplicationDTO;

public interface ApproveLoanUseCase {
    LoanApprovalAnswer approveLoan(int id);

    class LoanApprovalAnswer {
        LoanApprovalAnswerStatus status;
        LoanApplicationDTO loanApplication;
    }

    enum LoanApprovalAnswerStatus {
        APPROVED,
        REJECTED,
        NOT_FOUND
    }
}
