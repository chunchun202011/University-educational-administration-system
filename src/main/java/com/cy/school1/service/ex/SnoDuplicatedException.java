package com.cy.school1.service.ex;

/*用户名被占用的异常*/
public class SnoDuplicatedException extends ServiceException{
    // alt + insert ---> override methods

    public SnoDuplicatedException() {
        super();
    }

    public SnoDuplicatedException(String message) {
        super(message);
    }

    public SnoDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public SnoDuplicatedException(Throwable cause) {
        super(cause);
    }

    protected SnoDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
