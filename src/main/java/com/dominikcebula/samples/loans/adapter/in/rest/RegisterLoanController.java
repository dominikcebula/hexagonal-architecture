package com.dominikcebula.samples.loans.adapter.in.rest;

import com.dominikcebula.samples.loans.application.port.in.RegisterLoanUseCase;
import com.dominikcebula.samples.loans.application.port.in.dto.LoanApplicationDTO;
import com.dominikcebula.samples.loans.application.port.in.dto.LoanApplicationRegistrationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.dominikcebula.samples.loans.adapter.in.rest.ApiConstants.API_BASE;
import static com.dominikcebula.samples.loans.adapter.in.rest.ApiConstants.API_BASE_URI;
import static java.lang.String.valueOf;

@RestController
@RequestMapping(API_BASE)
@RequiredArgsConstructor
public class RegisterLoanController {
    private final RegisterLoanUseCase registerLoanUseCase;

    @PostMapping
    public ResponseEntity<LoanApplicationDTO> registerLoanApplication(LoanApplicationRegistrationDTO loanApplicationRegistrationDTO) {
        LoanApplicationDTO loanApplicationDTO = registerLoanUseCase.registerLoanApplication(loanApplicationRegistrationDTO);

        return ResponseEntity
                .created(API_BASE_URI.resolve(valueOf(loanApplicationDTO.getId())))
                .body(loanApplicationDTO);
    }
}
