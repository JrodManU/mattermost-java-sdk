package com.jrodmanu.mattermostjavasdk.models.parameters;

import com.jrodmanu.mattermostjavasdk.models.bodies.CreatePostBody;

/**
 * Object passed to the mattermost-java-sdk to create a new post
 */
public class CreatePostParams {

    /**
     * Builder for CreatePostParams
     */
    public static class Builder {

        private boolean setOnline;
        private String channelId;
        private final String message;
        private String rootId;
        private String[] fileIds;
        private Object props;

        /**
         * Constructor the the CreatePostParams Builder
         * @param message the message for the post to contain
         */
        public Builder(String message) {
            this.message = message;
        }

        /**
         * @param channelId the channel id to send the post in
         * @return the builder
         */
        public Builder setChannelId(String channelId) {
            this.channelId = channelId;
            return this;
        }

        /**
         * @param setOnline whether the user should be set to online when making the post
         * @return the builder
         */
        public Builder setSetOnline(boolean setOnline) {
            this.setOnline = setOnline;
            return this;
        }

        /**
         * @param rootId the id of the parent post
         * @return the builder
         */
        public Builder setRootId(String rootId) {
            this.rootId = rootId;
            return this;
        }

        /**
         * @param fileIds fileId's to add to the post
         * @return the builder
         */
        public Builder setFileIds(String[] fileIds) {
            this.fileIds = fileIds;
            return this;
        }

        /**
         * @param props additional properties for the post
         * @return the builder
         */
        public Builder setProps(Object props) {
            this.props = props;
            return this;
        }

        /**
         * @return a CreatePostParams object from the data given
         */
        public CreatePostParams build() {
            CreatePostParams createPostParams = new CreatePostParams();
            createPostParams.setOnline = setOnline;
            createPostParams.channelId = channelId;
            createPostParams.message = message;
            createPostParams.rootId = rootId;
            createPostParams.fileIds = fileIds;
            createPostParams.props = props;
            return createPostParams;
        }
    }

    public boolean setOnline;
    public String channelId;
    public String message;
    public String rootId;
    public String[] fileIds;
    public Object props;

    /**
     * Private because we are using a Builder
     */
    private CreatePostParams() {

    }

    /**
     * @return returns a CreatePostBody to send the Mattermost API
     */
    public CreatePostBody getCreatePostBody() {
       return new CreatePostBody(channelId, message, rootId, fileIds, props);
    }
}
