package com.example.awsbook.exception;

public class MyNoSuchElementException extends RuntimeException{
    public MyNoSuchElementException() {
    }

    public MyNoSuchElementException(String message) {
        super(message);
    }

    public MyNoSuchElementException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyNoSuchElementException(Throwable cause) {
        super(cause);
    }

    public MyNoSuchElementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
