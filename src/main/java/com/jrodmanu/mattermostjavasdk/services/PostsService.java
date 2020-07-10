package com.jrodmanu.mattermostjavasdk.services;

import com.jrodmanu.mattermostjavasdk.MattermostProcessor;
import com.jrodmanu.mattermostjavasdk.models.exceptions.MattermostException;
import com.jrodmanu.mattermostjavasdk.models.parameters.CreatePostParams;
import com.jrodmanu.mattermostjavasdk.models.responses.CreatePostResponse;

public class PostsService extends MattermostService {

    public PostsService(MattermostProcessor processor) {
        super(processor);
    }

    public CreatePostResponse createPost(CreatePostParams params) throws MattermostException {
        return processor.httpPost("/posts", params.getCreatePostBody(), CreatePostResponse.class);
    }

}
