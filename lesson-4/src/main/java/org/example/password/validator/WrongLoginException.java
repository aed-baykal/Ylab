package org.example.password.validator;

public class WrongLoginException extends RuntimeException {

    public WrongLoginException() {
    }

    public WrongLoginException(String message) {
        super(message);
    }
}
