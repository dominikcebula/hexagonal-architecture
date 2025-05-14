package com.dominikcebula.samples.loans.adapter.out.persistence.inmemory;

import com.dominikcebula.samples.loans.application.domain.model.loan.LoanApplication;
import com.dominikcebula.samples.loans.application.port.out.persistence.LoanApplicationRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Profile("in-memory-persistence")
@Primary
public class InMemoryLoanApplicationRepository implements LoanApplicationRepository {
    @Override
    public List<LoanApplication> findAll() {
        return List.of();
    }

    @Override
    public Optional<LoanApplication> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public LoanApplication save(LoanApplication loanApplication) {
        return null;
    }
}
