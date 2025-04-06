package com.dominikcebula.samples.loans.application.port.in.dto.mapper;

import com.dominikcebula.samples.loans.application.domain.model.identifier.Identifier;
import com.dominikcebula.samples.loans.application.domain.model.loan.LoanApplication;
import com.dominikcebula.samples.loans.application.port.in.dto.LoanApplicationDTO;
import com.dominikcebula.samples.loans.application.port.in.dto.MoneyDTO;
import org.javamoney.moneta.Money;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface LoanApplicationMapper {
    @Mapping(source = "identifier", target = "id")
    @Mapping(source = "amount.value", target = "amount")
    @Mapping(source = "termsInMonths.value", target = "termsInMonths")
    @Mapping(source = "applicant.identifier", target = "applicant.id")
    @Mapping(source = "applicant.firstName.value", target = "applicant.firstName")
    @Mapping(source = "applicant.lastName.value", target = "applicant.lastName")
    @Mapping(source = "applicant.birthDate.value", target = "applicant.birthDate")
    @Mapping(source = "applicant.creditScore.value", target = "applicant.creditScore")
    @Mapping(source = "applicant.email.value", target = "applicant.email")
    @Mapping(source = "applicant.phoneNumber.value", target = "applicant.phoneNumber")
    @Mapping(source = "applicant.employment.identifier", target = "applicant.employment.id")
    @Mapping(source = "applicant.employment.name.value", target = "applicant.employment.name")
    @Mapping(source = "applicant.employment.industry.value", target = "applicant.employment.industry")
    @Mapping(source = "applicant.employment.yearlyIncome", target = "applicant.employment.yearlyIncome")
    @Mapping(source = "applicant.employment.numberOfEmployees.value", target = "applicant.employment.numberOfEmployees")
    @Mapping(source = "applicant.employment.email.value", target = "applicant.employment.email")
    @Mapping(source = "applicant.employment.phoneNumber.value", target = "applicant.employment.phoneNumber")
    @Mapping(source = "applicant.employment.website.value", target = "applicant.employment.website")
    LoanApplicationDTO loanApplicationToLoanApplicationDTO(LoanApplication loanApplication);

    default int mapIdentifier(Identifier identifier) {
        return identifier.getValue()
                .orElseThrow(() -> new IllegalArgumentException("Identifier not present."));
    }

    default MoneyDTO mapMoney(Money money) {
        return new MoneyDTO(
                new BigDecimal(money.getNumberStripped().toPlainString()),
                money.getCurrency().getCurrencyCode()
        );
    }
}
