package org.lombold.common.validation;

public class ValidationException extends RuntimeException {

    Object value;

    public ValidationException(String message, Object value) {
        super(message);
        this.value = value;
    }
}
