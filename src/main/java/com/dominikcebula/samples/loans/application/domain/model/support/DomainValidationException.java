package com.dominikcebula.samples.loans.application.domain.model.support;

public class DomainValidationException extends RuntimeException {
    public DomainValidationException(String message) {
        super(message);
    }
}
