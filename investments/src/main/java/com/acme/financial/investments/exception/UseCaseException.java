package com.acme.financial.investments.exception;

public class UseCaseException extends RuntimeException {
    public UseCaseException(String message) {
        super(message);
    }
}
