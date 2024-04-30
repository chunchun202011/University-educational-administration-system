package com.cy.school1.service.ex;

/* 成绩总数超出限制的异常 */
public class ScoreCountLimitException extends ServiceException{
    public ScoreCountLimitException() {
        super();
    }

    public ScoreCountLimitException(String message) {
        super(message);
    }

    public ScoreCountLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScoreCountLimitException(Throwable cause) {
        super(cause);
    }

    protected ScoreCountLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
