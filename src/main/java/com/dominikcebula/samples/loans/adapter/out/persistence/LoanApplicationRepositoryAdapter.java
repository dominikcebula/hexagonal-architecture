package com.dominikcebula.samples.loans.adapter.out.persistence;

import com.dominikcebula.samples.loans.adapter.out.persistence.mapper.JpaLoanApplicationMapper;
import com.dominikcebula.samples.loans.application.domain.model.loan.LoanApplication;
import com.dominikcebula.samples.loans.application.port.out.persistence.LoanApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LoanApplicationRepositoryAdapter implements LoanApplicationRepository {
    private final SpringLoanApplicationRepository repository;
    private final JpaLoanApplicationMapper mapper;

    @Override
    public Optional<LoanApplication> findById(Long id) {
        return repository.findById(id)
                .map(mapper::jpaLoanApplicationEntityToLoanApplication);
    }

    @Override
    public LoanApplication save(LoanApplication loanApplication) {
        return null;
    }
}
