package com.jrodmanu.mattermostjavasdk;

import com.jrodmanu.mattermostjavasdk.models.common.Team;
import com.jrodmanu.mattermostjavasdk.models.parameters.SearchTeamsPaginatedParams;
import com.jrodmanu.mattermostjavasdk.models.responses.SearchTeamsPaginatedResponse;
import com.jrodmanu.mattermostjavasdk.services.ChannelsService;
import com.jrodmanu.mattermostjavasdk.services.MacroService;
import com.jrodmanu.mattermostjavasdk.services.PostsService;
import com.jrodmanu.mattermostjavasdk.services.TeamsService;

public class MattermostClient {

    public static class Builder {
        private String accessToken;
        private final String baseUrl;
        private String defaultTeam;

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
        public MattermostClient build() {
            MattermostClient client = new MattermostClient();
            MattermostProcessor processor = new MattermostProcessor(accessToken, baseUrl);
            client.channels = new ChannelsService(processor);
            client.posts = new PostsService(processor);
            client.teams = new TeamsService(processor);
            client.macro = new MacroService(client, processor);
            if (defaultTeam != null) {
                Team[] teams = client.teams.searchTeams(defaultTeam);
                processor.setDefaultTeamId(teams[0].id);
            }
            return client;
        }
    }

    public ChannelsService channels;
    public PostsService posts;
    public TeamsService teams;
    public MacroService macro;

    private MattermostClient() {

    }

}
