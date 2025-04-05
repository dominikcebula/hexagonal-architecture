package com.dominikcebula.samples.loans.adapter.in.rest;

import com.dominikcebula.samples.loans.application.port.in.RegisterLoanUseCase;
import com.dominikcebula.samples.loans.application.port.in.dto.LoanApplicationDTO;
import com.dominikcebula.samples.loans.application.port.in.dto.LoanApplicationRegistrationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static com.dominikcebula.samples.loans.adapter.in.rest.RegisterLoanController.API_BASE;
import static java.lang.String.valueOf;

@RestController
@RequestMapping(API_BASE)
@RequiredArgsConstructor
public class RegisterLoanController {
    static final String API_BASE = "/api/v1/loan-applications";
    private static final URI API_BASE_URI = URI.create(API_BASE);

    private final RegisterLoanUseCase registerLoanUseCase;

    @PostMapping
    public ResponseEntity<LoanApplicationDTO> registerLoanApplication(LoanApplicationRegistrationDTO loanApplicationRegistrationDTO) {
        LoanApplicationDTO loanApplicationDTO = registerLoanUseCase.registerLoanApplication(loanApplicationRegistrationDTO);

        return ResponseEntity
                .created(API_BASE_URI.resolve(valueOf(loanApplicationDTO.getId())))
                .body(loanApplicationDTO);
    }
}
