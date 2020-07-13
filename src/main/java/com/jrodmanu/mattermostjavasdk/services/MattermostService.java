package com.jrodmanu.mattermostjavasdk.services;

import com.jrodmanu.mattermostjavasdk.MattermostProcessor;

/**
 * Base class for all services communicating with the Mattermost API
 */
public class MattermostService {

    protected MattermostProcessor processor;

    /**
     * MattermostService constructor
     * @param processor used to process each request
     */
    public MattermostService(MattermostProcessor processor) {
        this.processor = processor;
    }
}
