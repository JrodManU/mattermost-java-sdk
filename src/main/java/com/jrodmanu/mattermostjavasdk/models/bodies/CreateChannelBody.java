package com.jrodmanu.mattermostjavasdk.models.bodies;

/**
 * Object to represent the body sent to the Mattermost API to create a channel
 */
public class CreateChannelBody {
    public String teamId;
    public String name;
    public String displayName;
    public String purpose;
    public String header;
    public String type;

    /**
     * CreateChannelBody constructor
     * @param teamId the teamId of the team that owns the channel
     * @param name the unique name of the channel
     * @param displayName the name displayed at the top of the channel
     * @param purpose the reason for the channele existing
     * @param header the text below the display name of the channel
     * @param type the type of channel public/private values: O/P
     */
    public CreateChannelBody(String teamId, String name, String displayName, String purpose, String header, String type) {
        this.teamId = teamId;
        this.name = name;
        this.displayName = displayName;
        this.purpose = purpose;
        this.header = header;
        this.type = type;
    }
}
