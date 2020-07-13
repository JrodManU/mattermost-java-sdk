package com.jrodmanu.mattermostjavasdk.services;

import com.jrodmanu.mattermostjavasdk.MattermostProcessor;
import com.jrodmanu.mattermostjavasdk.models.exceptions.MattermostException;
import com.jrodmanu.mattermostjavasdk.models.parameters.CreatePostParams;
import com.jrodmanu.mattermostjavasdk.models.common.Post;

/**
 * Handles all requests to the Mattermost API involving posts
 */
public class PostsService extends MattermostService {

    /**
     * Constructor for PostsService
     * @param processor used to process requests
     */
    public PostsService(MattermostProcessor processor) {
        super(processor);
    }

    /**
     * Creates a Mattermost post
     * @param params a CreatePostParams object
     * @return returns the post created
     * @throws MattermostException when the request fails
     */
    public Post createPost(CreatePostParams params) throws MattermostException {
        return processor.httpPost("/posts", params.getCreatePostBody(), Post.class);
    }

}
