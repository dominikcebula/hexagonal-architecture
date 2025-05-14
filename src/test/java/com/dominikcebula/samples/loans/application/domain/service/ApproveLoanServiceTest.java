package com.dominikcebula.samples.loans.application.domain.service;

import com.dominikcebula.samples.loans.application.port.in.ApproveLoanUseCase;
import com.dominikcebula.samples.loans.test.support.UseCaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@UseCaseTest
class ApproveLoanServiceTest {
    @Autowired
    private ApproveLoanUseCase approveLoanUseCase;

    @Test
    void shouldApproveLoan() {
        // TODO: implement use case
    }
}
