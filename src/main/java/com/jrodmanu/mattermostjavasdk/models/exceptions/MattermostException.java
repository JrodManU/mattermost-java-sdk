package com.jrodmanu.mattermostjavasdk.models.exceptions;

public class MattermostException extends Exception {
    public MattermostException(String message) {
        super(message);
    }
    public MattermostException(String message, Throwable cause) {
        super(message, cause);
    }
}
