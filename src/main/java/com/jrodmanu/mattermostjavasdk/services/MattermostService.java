package com.jrodmanu.mattermostjavasdk.services;

import com.jrodmanu.mattermostjavasdk.MattermostProcessor;

public class MattermostService {

    protected MattermostProcessor processor;

    public MattermostService(MattermostProcessor processor) {
        this.processor = processor;
    }
}
