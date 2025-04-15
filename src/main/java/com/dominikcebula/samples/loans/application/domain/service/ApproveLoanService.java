package com.dominikcebula.samples.loans.application.domain.service;

import com.dominikcebula.samples.loans.application.port.in.ApproveLoanUseCase;
import com.dominikcebula.samples.loans.application.port.in.dto.mapper.LoanApplicationMapper;
import com.dominikcebula.samples.loans.application.port.out.persistence.LoanApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApproveLoanService implements ApproveLoanUseCase {
    private final LoanApplicationRepository repository;
    private final LoanApplicationMapper mapper;

    @Override
    public LoanApprovalAnswer approveLoan(int id) {
        return repository.findById(id)
                .map(loanApplication -> {
                    loanApplication.approve();

                    loanApplication = repository.save(loanApplication);

                    return LoanApprovalAnswer.approved(mapper.loanApplicationToLoanApplicationDTO(loanApplication));
                })
                .orElse(LoanApprovalAnswer.loanNotFound());
    }
}
