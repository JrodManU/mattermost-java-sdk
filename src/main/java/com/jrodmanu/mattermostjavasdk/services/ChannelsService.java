package com.jrodmanu.mattermostjavasdk.services;

import com.jrodmanu.mattermostjavasdk.MattermostProcessor;
import com.jrodmanu.mattermostjavasdk.models.common.Channel;
import com.jrodmanu.mattermostjavasdk.models.parameters.SearchChannelsParams;

public class ChannelsService extends MattermostService {

    public ChannelsService(MattermostProcessor processor) {
        super(processor);
    }

    public Channel[] searchChannels(SearchChannelsParams params) {
        if (params.teamId == null) {
            params.teamId = processor.getDefaultTeamId();
        }
        String route = String.format("/teams/%s/channels/search", params.teamId);
        return processor.httpPost(route, params.getSearchTermBody(), Channel[].class);
    }
}