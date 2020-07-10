package com.jrodmanu.mattermostjavasdk;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jrodmanu.mattermostjavasdk.models.exceptions.MattermostException;
import com.jrodmanu.mattermostjavasdk.models.responses.MattermostExceptionResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MattermostProcessor {

    private HttpClient httpClient;
    private Gson gson;
    private final String accessToken;
    private final String baseUrl;
    private String defaultTeamId;

    public MattermostProcessor(String accessToken, String baseUrl) {
        this.accessToken = accessToken;
        this.baseUrl = baseUrl;
    }

    public <T> T httpPost(String route, Object body, Class<T> responseType) throws MattermostException {
        T response;
        String bodyString = getGson().toJson(body);
        String uriString = baseUrl + route;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .setHeader("Content-type", "application/json")
                    .setHeader("Authorization", "Bearer " + accessToken)
                    .POST(HttpRequest.BodyPublishers.ofString(bodyString))
                    .uri(new URI(uriString))
                    .build();
            HttpResponse<String> responseRaw = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            // detect if error occurred
            if (responseRaw.statusCode() >= 400) {
                MattermostExceptionResponse exceptionResponse = getGson().fromJson(responseRaw.body(), MattermostExceptionResponse.class);
                throw new MattermostException(exceptionResponse.statusCode + ": " + exceptionResponse.message);
            } else {
                // otherwise returned the data parsed into the right type
                response = getGson().fromJson(responseRaw.body(), responseType);
            }
        } catch(IOException |InterruptedException e) {
            String message = "Error sending httpPost to " + route;
            System.out.println(message);
            e.printStackTrace();
            throw new MattermostException(message, e);
        } catch(URISyntaxException e) {
            String message = "Tried to send httpPost but URI is invalid " + uriString;
            System.out.println(message);
            e.printStackTrace();
            throw new MattermostException(message, e);
        }
        return response;
    }

    // creates the httpClient if not created already, returns it otherwise
    private HttpClient getHttpClient() {
        if (httpClient == null) {
            httpClient = HttpClient.newHttpClient();
        }
        return httpClient;
    }

    // creates the gson if not created already, returns it otherwise
    private Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();
        }
        return gson;
    }

    public String getDefaultTeamId() {
        return defaultTeamId;
    }

    public void setDefaultTeamId(String defaultTeamId) {
        this.defaultTeamId = defaultTeamId;
    }
}
