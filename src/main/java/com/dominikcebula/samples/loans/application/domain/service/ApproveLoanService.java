package com.dominikcebula.samples.loans.application.domain.service;

import com.dominikcebula.samples.loans.adapter.out.persistence.LoanApplicationRepository;
import com.dominikcebula.samples.loans.application.port.in.ApproveLoanUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApproveLoanService implements ApproveLoanUseCase {
    private final LoanApplicationRepository repository;

    @Override
    public LoanApprovalAnswer approveLoan(int id) {
        return null;
    }
}
