package com.dominikcebula.samples.loans.application.port.in.dto.mapper;

import com.dominikcebula.samples.loans.application.domain.model.loan.LoanAmount;
import com.dominikcebula.samples.loans.application.domain.model.loan.LoanApplication;
import com.dominikcebula.samples.loans.application.domain.model.loan.TermsInMonths;
import com.dominikcebula.samples.loans.application.port.in.dto.LoanApplicationDTO;
import com.dominikcebula.samples.loans.application.port.in.dto.LoanApplicationRegistrationDTO;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ObjectFactory;

import static com.dominikcebula.samples.loans.application.port.in.dto.mapper.LoanApplicationMapper.LoanApplicationFactory;

@Mapper(componentModel = "spring", uses = {IdentifierMapper.class, MoneyMapper.class, ApplicantMapper.class, EmploymentMapper.class, LoanApplicationFactory.class})
public interface LoanApplicationMapper {
    @Mapping(source = "identifier", target = "id")
    @Mapping(source = "amount.value", target = "amount")
    @Mapping(source = "termsInMonths.value", target = "termsInMonths")
    LoanApplicationDTO loanApplicationToLoanApplicationDTO(LoanApplication loanApplication);

    LoanApplication loanApplicationRegistrationDTOToLoanApplication(LoanApplicationRegistrationDTO loanApplicationRegistrationDTO);

    @RequiredArgsConstructor
    class LoanApplicationFactory {
        private final ApplicantMapper applicantMapper;
        private final MoneyMapper moneyMapper;

        @ObjectFactory
        LoanApplication createLoanApplication(LoanApplicationRegistrationDTO loanApplicationRegistrationDTO) {
            return new LoanApplication(
                    applicantMapper.applicantRegistrationDTOToApplicant(loanApplicationRegistrationDTO.applicant()),
                    new LoanAmount(moneyMapper.mapMoneyDTOToMoney(loanApplicationRegistrationDTO.amount())),
                    new TermsInMonths(loanApplicationRegistrationDTO.termsInMonths())
            );
        }
    }
}
