package com.jrodmanu.mattermostjavasdk.services;

import com.jrodmanu.mattermostjavasdk.MattermostClient;
import com.jrodmanu.mattermostjavasdk.MattermostProcessor;
import com.jrodmanu.mattermostjavasdk.models.parameters.CreatePostParams;
import com.jrodmanu.mattermostjavasdk.models.responses.CreatePostResponse;

public class MacroService extends MattermostService {

    private final MattermostClient client;

    public MacroService(MattermostClient client, MattermostProcessor processor) {
        super(processor);
        this.client = client;
    }

}
