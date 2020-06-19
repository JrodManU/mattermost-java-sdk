package com.jrodmanu.mattermostjavasdk.models.responses;

import com.jrodmanu.mattermostjavasdk.models.common.PostMetadata;

public class CreatePostResponse {
    public String id;
    public long createAt;
    public long updateAt;
    public long deleteAt;
    public long editAt;
    public String userId;
    public String channelId;
    public String rootId;
    public String parentId;
    public String originalId;
    public String message;
    public String type;
    public Object props;
    public String hashtag;
    public String[] fileIds;
    public String pendingPostId;
    public PostMetadata postMetadata;
}
