package com.jrodmanu.mattermostjavasdk;

import com.jrodmanu.mattermostjavasdk.models.common.Team;
import com.jrodmanu.mattermostjavasdk.models.exceptions.MattermostException;
import com.jrodmanu.mattermostjavasdk.services.ChannelsService;
import com.jrodmanu.mattermostjavasdk.services.PostsService;
import com.jrodmanu.mattermostjavasdk.services.TeamsService;

/**
 * Client to be used by users of mattermost-java-sdk
 */
public class MattermostClient {

    /**
     * Builder for the MattermostClient
     */
    public static class Builder {
        private String accessToken;
        private final String baseUrl;
        private String defaultTeam;
        private String defaultTeamId;

        /**
         * Constructor for MattermostClient Builder
         * @param baseUrl the api endpoint of the Mattermost server
         */
        public Builder(String baseUrl) {
            this.baseUrl = baseUrl;
        }

        /**
         * @param accessToken the access token used to access the Mattermost API
         * @return the builder
         */
        public Builder setAccessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        /**
         * Any requests that need a teamId will default to this if none is given
         * @param defaultTeam the name of the team to default to
         * @return the builder
         */
        public Builder setDefaultTeam(String defaultTeam) {
            this.defaultTeam = defaultTeam;
            return this;
        }

        /**
         * Any requests that need a teamId will default to this if none is given
         * @param defaultTeamId the id of the team to default to
         * @return the builder
         */
        public Builder setDefaultTeamId(String defaultTeamId) {
            this.defaultTeamId = defaultTeamId;
            return this;
        }

        /**
         * Builds the MattermostClient using the data given. Will also fetch the teamId if given a defaultTeam
         * instead of a defaultTeamId
         * @return a new MattermostClient for the user to use
         * @throws MattermostException when it fails to set the defaultTeamId when only given defaultTeam name
         */
        public MattermostClient build() throws MattermostException {
            MattermostClient client = new MattermostClient();
            client.processor = new MattermostProcessor(accessToken, baseUrl);
            client.channels = new ChannelsService(client.processor);
            client.posts = new PostsService(client.processor);
            client.teams = new TeamsService(client.processor);
            if (defaultTeam != null) {
                client.setDefaultTeam(defaultTeam);
            } else {
                client.setDefaultTeamId(defaultTeamId);
            }
            return client;
        }
    }

    public ChannelsService channels;
    public PostsService posts;
    public TeamsService teams;
    private MattermostProcessor processor;

    /**
     * Private because we are using a Builder
     */
    private MattermostClient() {

    }

    /**
     * Will search for the default team given and set the defaultTeamId using the first result
     * @param defaultTeam the name of the team to default to
     * @throws MattermostException when it fails to find the defaultTeamId of the defaultTeam given
     */
    public void setDefaultTeam(String defaultTeam) throws MattermostException {
        Team[] teamsArray = teams.searchTeams(defaultTeam);
        if (teamsArray.length > 0) {
            setDefaultTeamId(teamsArray[0].id);
        } else {
            throw new MattermostException("Could not find team to set default team " + defaultTeam);
        }
    }

    /**
     * @param defaultTeamId the new default team id
     */
    public void setDefaultTeamId(String defaultTeamId) {
        processor.setDefaultTeamId(defaultTeamId);
    }
}
