package com.jrodmanu.mattermostjavasdk.services;

import com.jrodmanu.mattermostjavasdk.MattermostProcessor;
import com.jrodmanu.mattermostjavasdk.models.parameters.CreatePostParams;
import com.jrodmanu.mattermostjavasdk.models.responses.CreatePostResponse;

public class PostsService extends MattermostService {

    public PostsService(MattermostProcessor processor) {
        super(processor);
    }

    public CreatePostResponse createPost(CreatePostParams params) {
        return processor.httpPost("/posts", params.getCreatePostBody(), CreatePostResponse.class);
    }

}
