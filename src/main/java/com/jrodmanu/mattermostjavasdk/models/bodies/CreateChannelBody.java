package com.jrodmanu.mattermostjavasdk.models.bodies;

public class CreateChannelBody {
    public String teamId;
    public String name;
    public String displayName;
    public String purpose;
    public String header;
    public String type;

    public CreateChannelBody(String teamId, String name, String displayName, String purpose, String header, String type) {
        this.teamId = teamId;
        this.name = name;
        this.displayName = displayName;
        this.purpose = purpose;
        this.header = header;
        this.type = type;
    }
}
