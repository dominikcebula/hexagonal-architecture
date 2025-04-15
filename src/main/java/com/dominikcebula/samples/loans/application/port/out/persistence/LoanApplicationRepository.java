package com.dominikcebula.samples.loans.application.port.out.persistence;

import com.dominikcebula.samples.loans.application.domain.model.loan.LoanApplication;

import java.util.Optional;

public interface LoanApplicationRepository {
    Optional<LoanApplication> findById(Long id);

    LoanApplication save(LoanApplication loanApplication);
}
