package com.dominikcebula.samples.loans.adapter.out.persistence;

import com.dominikcebula.samples.loans.application.domain.model.loan.LoanApplication;
import com.dominikcebula.samples.loans.application.port.out.persistence.LoanApplicationRepository;

import java.util.Optional;

public class LoanApplicationRepositoryAdapter implements LoanApplicationRepository {
    @Override
    public Optional<LoanApplication> findById(int id) {
        return Optional.empty();
    }

    @Override
    public LoanApplication save(LoanApplication loanApplication) {
        return null;
    }
}
