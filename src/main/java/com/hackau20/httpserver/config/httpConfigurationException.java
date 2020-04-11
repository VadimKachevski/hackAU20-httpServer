package com.hackau20.httpserver.config;

public class httpConfigurationException  extends  RuntimeException{

    public httpConfigurationException() {
    }

    public httpConfigurationException(String message) {
        super(message);
    }

    public httpConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public httpConfigurationException(Throwable cause) {
        super(cause);
    }

    public httpConfigurationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
