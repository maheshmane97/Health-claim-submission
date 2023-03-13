package com.hnt.hcm.customExceptions;

public class InputFieldException extends RuntimeException {

    private String message;

    public InputFieldException() {
        super();
    }

    public InputFieldException(String message) {
        super(message);
    }

    public InputFieldException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputFieldException(Throwable cause) {
        super(cause);
    }

    protected InputFieldException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
