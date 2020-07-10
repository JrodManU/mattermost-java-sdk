package com.jrodmanu.mattermostjavasdk;

import com.jrodmanu.mattermostjavasdk.models.common.Team;
import com.jrodmanu.mattermostjavasdk.models.exceptions.MattermostException;
import com.jrodmanu.mattermostjavasdk.services.ChannelsService;
import com.jrodmanu.mattermostjavasdk.services.PostsService;
import com.jrodmanu.mattermostjavasdk.services.TeamsService;

public class MattermostClient {

    public static class Builder {
        private String accessToken;
        private final String baseUrl;
        private String defaultTeam;
        private String defaultTeamId;

        public Builder(String baseUrl) {
            this.baseUrl = baseUrl;
        }
        public Builder setAccessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }
        public Builder setDefaultTeam(String defaultTeam) {
            this.defaultTeam = defaultTeam;
            return this;
        }
        public Builder setDefaultTeamId(String defaultTeamId) {
            this.defaultTeamId = defaultTeamId;
            return this;
        }
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

    private MattermostClient() {

    }

    public void setDefaultTeam(String defaultTeam) throws MattermostException {
        Team[] teamsArray = teams.searchTeams(defaultTeam);
        if (teamsArray.length > 0) {
            setDefaultTeamId(teamsArray[0].id);
        } else {
            throw new MattermostException("Could not find team to set default team " + defaultTeam);
        }
    }

    public void setDefaultTeamId(String defaultTeamId) {
        processor.setDefaultTeamId(defaultTeamId);
    }
}
