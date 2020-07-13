package com.jrodmanu.mattermostjavasdk.models.common;

/**
 * Representation of Mattermost channel
 */
public class Channel {
    public String id;
    public long createAt;
    public long updateAt;
    public long deleteAt;
    public String teamId;
    public String type;
    public String displayName;
    public String name;
    public String header;
    public String purpose;
    public long lastPostAt;
    public int totalMsgCount;
    public long extraUpdateAt;
    public String creatorId;
}