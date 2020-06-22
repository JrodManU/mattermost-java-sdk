package com.jrodmanu.mattermostjavasdk;

import com.jrodmanu.mattermostjavasdk.models.common.Team;
import com.jrodmanu.mattermostjavasdk.services.ChannelsService;
import com.jrodmanu.mattermostjavasdk.services.MacroService;
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
        public MattermostClient build() {
            MattermostClient client = new MattermostClient();
            client.processor = new MattermostProcessor(accessToken, baseUrl);
            client.channels = new ChannelsService(client.processor);
            client.posts = new PostsService(client.processor);
            client.teams = new TeamsService(client.processor);
            client.macro = new MacroService(client, client.processor);
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
    public MacroService macro;
    private MattermostProcessor processor;

    private MattermostClient() {

    }

    public void setDefaultTeam(String defaultTeam) {
        Team[] teamsArray = teams.searchTeams(defaultTeam);
        setDefaultTeamId(teamsArray[0].id);
    }

    public void setDefaultTeamId(String defaultTeamId) {
        processor.setDefaultTeamId(defaultTeamId);
    }
}
