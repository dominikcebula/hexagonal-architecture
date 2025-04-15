package com.dominikcebula.samples.loans.adapter.out.persistence;

import com.dominikcebula.samples.loans.adapter.out.persistence.entity.JpaLoanApplicationEntity;
import org.springframework.data.repository.CrudRepository;

public interface SpringLoanApplicationRepository extends CrudRepository<JpaLoanApplicationEntity, Long> {
}
