package com.jrodmanu.mattermostjavasdk.models.bodies;

/**
 * Object used to represent the body sent to the Mattermost API to create a post
 */
public class CreatePostBody {
    public String channelId;
    public String message;
    public String rootId;
    public String[] fileIds;
    public Object props;

    /**
     * CreatePostBody constructor
     * @param channelId the id of the channel to post it in
     * @param message the message of the post
     * @param rootId the id of the parent post
     * @param fileIds the ids of the files to add to the post
     * @param props additional properties of the post
     */
    public CreatePostBody(String channelId, String message, String rootId, String[] fileIds, Object props) {
        this.channelId = channelId;
        this.message = message;
        this.rootId = rootId;
        this.fileIds = fileIds;
        this.props = props;
    }
}
