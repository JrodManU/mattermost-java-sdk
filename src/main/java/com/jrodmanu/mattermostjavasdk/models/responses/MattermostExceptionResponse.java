package com.jrodmanu.mattermostjavasdk.models.responses;

/**
 * Represents an exception message from the Mattermost API
 */
public class MattermostExceptionResponse {
    public String id;
    public String message;
    public String detailedError;
    public String requestId;
    public int statusCode;
}
