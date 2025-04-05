package com.dominikcebula.samples.loans.adapter.out.persistence;

import com.dominikcebula.samples.loans.application.domain.model.loan.LoanApplication;

import java.util.Optional;

public interface LoanApplicationRepository {
    Optional<LoanApplication> findById(int id);

    LoanApplication save(LoanApplication loanApplication);
}
