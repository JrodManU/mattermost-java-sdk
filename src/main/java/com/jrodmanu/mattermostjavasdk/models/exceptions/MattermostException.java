package com.jrodmanu.mattermostjavasdk.models.exceptions;

/**
 * Generic error thrown by the mattermost-java-sdk
 */
public class MattermostException extends Exception {
    /**
     * Constructor for a new error
     * @param message the message to be printed for the exception
     */
    public MattermostException(String message) {
        super(message);
    }

    /**
     * Constuctor to keep stack trace
     * @param message the message to be printed for the exception
     * @param cause the Throwable object that caused this exception
     */
    public MattermostException(String message, Throwable cause) {
        super(message, cause);
    }
}
