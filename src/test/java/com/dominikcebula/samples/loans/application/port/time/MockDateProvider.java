package com.dominikcebula.samples.loans.application.port.time;

import com.dominikcebula.samples.loans.application.domain.model.support.spring.BeanProviderMock;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static java.time.Month.MAY;

@Component
@Primary
public class MockDateProvider extends CurrentDateProvider {
    public static void setUp() {
        BeanProviderMock.setUp();
        BeanProviderMock.registerBean(CurrentDateProvider.class, new MockDateProvider());
    }

    public static void tearDown() {
        BeanProviderMock.tearDown();
    }

    @Override
    public LocalDate now() {
        return LocalDate.of(2025, MAY, 17);
    }
}
