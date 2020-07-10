package com.jrodmanu.mattermostjavasdk.models.parameters;

import com.jrodmanu.mattermostjavasdk.models.bodies.CreateChannelBody;
import com.jrodmanu.mattermostjavasdk.models.bodies.CreatePostBody;

public class CreateChannelParams {
    public static class Builder {

        private String teamId;
        private final String name;
        private final String displayName;
        private String purpose;
        private String header;
        private final String type;

        public Builder(String name, String displayName, String type) {
            this.name = name;
            this.displayName = displayName;
            this.type = type;
        }

        public CreateChannelParams.Builder setTeamId(String teamId) {
            this.teamId = teamId;
            return this;
        }
        public CreateChannelParams.Builder setPurpose(String purpose) {
            this.purpose = purpose;
            return this;
        }
        public CreateChannelParams.Builder setHeader(String header) {
            this.header = header;
            return this;
        }

        public CreateChannelParams build() {
            CreateChannelParams createChannelParams = new CreateChannelParams();
            createChannelParams.teamId = teamId;
            createChannelParams.name = name;
            createChannelParams.displayName = displayName;
            createChannelParams.purpose = purpose;
            createChannelParams.header = header;
            createChannelParams.type = type;
            return createChannelParams;
        }
    }

    public String teamId;
    public String name;
    public String displayName;
    public String purpose;
    public String header;
    public String type;

    private CreateChannelParams() {

    }

    public CreateChannelBody getCreateChannelBody() {
        return new CreateChannelBody(teamId, name, displayName, purpose, header, type);
    }
}
