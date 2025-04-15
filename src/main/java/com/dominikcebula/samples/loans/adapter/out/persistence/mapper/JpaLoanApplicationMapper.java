package com.dominikcebula.samples.loans.adapter.out.persistence.mapper;

import com.dominikcebula.samples.loans.adapter.out.persistence.entity.JpaLoanApplicationEntity;
import com.dominikcebula.samples.loans.application.domain.model.identifier.Identifier;
import com.dominikcebula.samples.loans.application.domain.model.loan.LoanAmount;
import com.dominikcebula.samples.loans.application.domain.model.loan.LoanApplication;
import com.dominikcebula.samples.loans.application.domain.model.loan.TermsInMonths;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

import static com.dominikcebula.samples.loans.adapter.out.persistence.mapper.JpaLoanApplicationMapper.LoanApplicationFromJpaFactory;

@Mapper(componentModel = "spring", uses = {LoanApplicationFromJpaFactory.class})
public interface JpaLoanApplicationMapper {
    LoanApplication jpaLoanApplicationEntityToLoanApplication(JpaLoanApplicationEntity jpaLoanApplicationEntity);

    @Component
    @RequiredArgsConstructor
    class LoanApplicationFromJpaFactory {
        private final JpaMoneyMapper jpaMoneyMapper;

        @ObjectFactory
        LoanApplication createLoanApplication(JpaLoanApplicationEntity jpaLoanApplicationEntity) {
            return new LoanApplication(
                    new Identifier(jpaLoanApplicationEntity.getId()),
                    null,
                    new LoanAmount(jpaMoneyMapper.mapJpaMoneyToMoney(jpaLoanApplicationEntity.getAmount(), jpaLoanApplicationEntity.getCurrency())),
                    new TermsInMonths(jpaLoanApplicationEntity.getTermsInMonths()),
                    jpaLoanApplicationEntity.getStatus()
            );
        }
    }
}
