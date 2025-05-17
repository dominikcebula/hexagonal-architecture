package com.dominikcebula.samples.loans.application.port.time;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static java.time.Month.MAY;

@Component
@Primary
public class MockDateProvider extends CurrentDateProvider {
    @Override
    public LocalDate now() {
        return LocalDate.of(2025, MAY, 17);
    }
}
