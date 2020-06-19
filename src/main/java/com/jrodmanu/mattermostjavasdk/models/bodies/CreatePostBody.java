package com.jrodmanu.mattermostjavasdk.models.bodies;

public class CreatePostBody {
    public String channelId;
    public String message;
    public String rootId;
    public String[] fileIds;
    public Object props;

    public CreatePostBody(String channelId, String message, String rootId, String[] fileIds, Object props) {
        this.channelId = channelId;
        this.message = message;
        this.rootId = rootId;
        this.fileIds = fileIds;
        this.props = props;
    }
}
