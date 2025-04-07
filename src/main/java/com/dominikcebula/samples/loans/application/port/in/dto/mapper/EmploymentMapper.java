package com.dominikcebula.samples.loans.application.port.in.dto.mapper;

import com.dominikcebula.samples.loans.application.domain.model.contact.Email;
import com.dominikcebula.samples.loans.application.domain.model.contact.PhoneNumber;
import com.dominikcebula.samples.loans.application.domain.model.contact.Website;
import com.dominikcebula.samples.loans.application.domain.model.employment.EmployerName;
import com.dominikcebula.samples.loans.application.domain.model.employment.Employment;
import com.dominikcebula.samples.loans.application.domain.model.employment.Industry;
import com.dominikcebula.samples.loans.application.domain.model.employment.NumberOfEmployees;
import com.dominikcebula.samples.loans.application.port.in.dto.EmploymentDTO;
import com.dominikcebula.samples.loans.application.port.in.dto.EmploymentRegistrationDTO;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ObjectFactory;

import static com.dominikcebula.samples.loans.application.port.in.dto.mapper.EmploymentMapper.EmploymentFactory;

@Mapper(componentModel = "spring", uses = {IdentifierMapper.class, MoneyMapper.class, EmploymentFactory.class})
public interface EmploymentMapper {
    @Mapping(source = "identifier", target = "id")
    @Mapping(source = "name.value", target = "name")
    @Mapping(source = "industry.value", target = "industry")
    @Mapping(source = "yearlyIncome", target = "yearlyIncome")
    @Mapping(source = "numberOfEmployees.value", target = "numberOfEmployees")
    @Mapping(source = "email.value", target = "email")
    @Mapping(source = "phoneNumber.value", target = "phoneNumber")
    @Mapping(source = "website.value", target = "website")
    EmploymentDTO employmentToEmploymentDTO(Employment employment);

    Employment employmentRegistrationDTOToEmployment(EmploymentRegistrationDTO employmentRegistrationDTO);

    @RequiredArgsConstructor
    class EmploymentFactory {
        private final MoneyMapper moneyMapper;

        @ObjectFactory
        Employment createEmployment(EmploymentRegistrationDTO employmentRegistrationDTO) {
            return new Employment(
                    new EmployerName(employmentRegistrationDTO.name()),
                    new Industry(employmentRegistrationDTO.industry()),
                    moneyMapper.mapMoneyDTOToMoney(employmentRegistrationDTO.yearlyIncome()),
                    new NumberOfEmployees(employmentRegistrationDTO.numberOfEmployees()),
                    new Email(employmentRegistrationDTO.email()),
                    new PhoneNumber(employmentRegistrationDTO.phoneNumber()),
                    new Website(employmentRegistrationDTO.website())
            );
        }
    }
}
