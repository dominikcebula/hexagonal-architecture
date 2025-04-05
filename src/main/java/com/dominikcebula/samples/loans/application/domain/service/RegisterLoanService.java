package com.dominikcebula.samples.loans.application.domain.service;

import com.dominikcebula.samples.loans.adapter.out.persistence.LoanApplicationRepository;
import com.dominikcebula.samples.loans.application.port.in.RegisterLoanUseCase;
import com.dominikcebula.samples.loans.application.port.in.dto.LoanApplicationDTO;
import com.dominikcebula.samples.loans.application.port.in.dto.LoanApplicationRegistrationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterLoanService implements RegisterLoanUseCase {
    private final LoanApplicationRepository repository;

    @Override
    public LoanApplicationDTO registerLoanApplication(LoanApplicationRegistrationDTO loanApplicationRegistrationDTO) {
        return null;
    }
}
