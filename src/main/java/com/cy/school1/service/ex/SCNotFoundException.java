package com.cy.school1.service.ex;

public class SCNotFoundException extends ServiceException{
    public SCNotFoundException() {
        super();
    }

    public SCNotFoundException(String message) {
        super(message);
    }

    public SCNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SCNotFoundException(Throwable cause) {
        super(cause);
    }

    protected SCNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
