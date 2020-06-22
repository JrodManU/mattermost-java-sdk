package com.jrodmanu.mattermostjavasdk.models.responses;

import java.net.http.HttpResponse;

public class MattermostResponse <T> {
    public T body;
    public int statusCode;

    public MattermostResponse(T body, int statusCode) {
        this.body = body;
        this.statusCode = statusCode;
    }
}
