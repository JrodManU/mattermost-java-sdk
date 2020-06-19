package com.jrodmanu.mattermostjavasdk.models.parameters;

import com.jrodmanu.mattermostjavasdk.models.bodies.CreatePostBody;

public class CreatePostParams {

    public static class Builder {

        private boolean setOnline;
        private String channelId;
        private final String message;
        private String rootId;
        private String[] fileIds;
        private Object props;

        public Builder(String message) {
            this.message = message;
        }

        public Builder setChannelId(String channelId) {
            this.channelId = channelId;
            return this;
        }
        public Builder setSetOnline(boolean setOnline) {
            this.setOnline = setOnline;
            return this;
        }
        public Builder setRootId(String rootId) {
            this.rootId = rootId;
            return this;
        }
        public Builder setFileIds(String[] fileIds) {
            this.fileIds = fileIds;
            return this;
        }
        public Builder setProps(Object props) {
            this.props = props;
            return this;
        }

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

    private CreatePostParams() {

    }

    public CreatePostBody getCreatePostBody() {
       return new CreatePostBody(channelId, message, rootId, fileIds, props);
    }
}
