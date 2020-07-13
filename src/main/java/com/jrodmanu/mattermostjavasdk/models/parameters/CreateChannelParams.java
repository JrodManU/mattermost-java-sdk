package com.jrodmanu.mattermostjavasdk.models.parameters;

import com.jrodmanu.mattermostjavasdk.models.bodies.CreateChannelBody;

/**
 * Object passed to the mattermost-java-sdk to create a channel
 */
public class CreateChannelParams {

    /**
     * Builder class for CreateChannelParams
     */
    public static class Builder {

        private String teamId;
        private final String name;
        private final String displayName;
        private String purpose;
        private String header;
        private final String type;

        /**
         * Constructor for CreateChannelParams Builder
         * @param name unique name of the channel
         * @param displayName the name to display at the top of the channel page
         * @param type type of channel public/private values: O/P
         */
        public Builder(String name, String displayName, String type) {
            this.name = name;
            this.displayName = displayName;
            this.type = type;
        }

        /**
         * @param teamId id of the team that this channel should be a part of
         * @return the builder
         */
        public CreateChannelParams.Builder setTeamId(String teamId) {
            this.teamId = teamId;
            return this;
        }

        /**
         * @param purpose reason why the channel exists
         * @return the builder
         */
        public CreateChannelParams.Builder setPurpose(String purpose) {
            this.purpose = purpose;
            return this;
        }

        /**
         * @param header text to display below the display name of the channel
         * @return the builder
         */
        public CreateChannelParams.Builder setHeader(String header) {
            this.header = header;
            return this;
        }

        /**
         * @return the CreateChannel params from the data given
         */
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

    /**
     * Private because we are using a Builder
     */
    private CreateChannelParams() {

    }

    /**
     * @return returns a body that can be sent the the Mattermost API
     */
    public CreateChannelBody getCreateChannelBody() {
        return new CreateChannelBody(teamId, name, displayName, purpose, header, type);
    }
}
