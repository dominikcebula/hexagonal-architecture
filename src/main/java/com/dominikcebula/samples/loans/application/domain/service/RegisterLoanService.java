package com.dominikcebula.samples.loans.application.domain.service;

import com.dominikcebula.samples.loans.adapter.out.persistence.LoanApplicationRepository;
import com.dominikcebula.samples.loans.application.domain.model.loan.LoanApplication;
import com.dominikcebula.samples.loans.application.port.in.RegisterLoanUseCase;
import com.dominikcebula.samples.loans.application.port.in.dto.LoanApplicationDTO;
import com.dominikcebula.samples.loans.application.port.in.dto.LoanApplicationRegistrationDTO;
import com.dominikcebula.samples.loans.application.port.in.dto.mapper.LoanApplicationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterLoanService implements RegisterLoanUseCase {
    private final LoanApplicationRepository repository;
    private final LoanApplicationMapper mapper;

    @Override
    public LoanApplicationDTO registerLoanApplication(LoanApplicationRegistrationDTO loanApplicationRegistrationDTO) {
        LoanApplication loanApplication = mapper.loanApplicationRegistrationDTOToLoanApplication(loanApplicationRegistrationDTO);

        loanApplication = repository.save(loanApplication);

        return mapper.loanApplicationToLoanApplicationDTO(loanApplication);
    }
}
