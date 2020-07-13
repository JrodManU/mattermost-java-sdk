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

/**
 * Used to process all requests sent to the Mattermost API
 */
public class MattermostProcessor {

    private HttpClient httpClient;
    private Gson gson;
    private final String accessToken;
    private final String baseUrl;
    private String defaultTeamId;

    /**
     *
     * @param accessToken access token used to authenticate with the Mattermost API
     * @param baseUrl the API endpoint of the Mattermost server
     */
    public MattermostProcessor(String accessToken, String baseUrl) {
        this.accessToken = accessToken;
        this.baseUrl = baseUrl;
    }

    /**
     * Sends a post request to the Mattermost API and parses the response.
     * @param route The route to send the request to. Adds on to the api endpoint. Start with a /
     * @param body The JSON body to send as part of the post request.
     * @param responseType The type of class to parse the response into
     * @param <T> The generic for the type of class to parse the response into.
     * @return The response parsed into the type of class given
     * @throws MattermostException when the http request returns an error or there is an error sending it
     */
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
        } catch(IOException | InterruptedException e) {
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

    /**
     * Creates the http client if not created yet
     * @return an HttpClient to send requests with.
     */
    private HttpClient getHttpClient() {
        if (httpClient == null) {
            httpClient = HttpClient.newHttpClient();
        }
        return httpClient;
    }

    /**
     * Creates the gson tool if not create yet
     * @return an Gson object to parse JSON with
     */
    private Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();
        }
        return gson;
    }

    /**
     * @return the default team id
     */
    public String getDefaultTeamId() {
        return defaultTeamId;
    }

    /**
     * @param defaultTeamId the new default team id
     */
    public void setDefaultTeamId(String defaultTeamId) {
        this.defaultTeamId = defaultTeamId;
    }
}
