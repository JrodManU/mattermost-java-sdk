package com.jrodmanu.mattermostjavasdk.services;

import com.jrodmanu.mattermostjavasdk.MattermostProcessor;
import com.jrodmanu.mattermostjavasdk.models.common.Channel;
import com.jrodmanu.mattermostjavasdk.models.exceptions.MattermostException;
import com.jrodmanu.mattermostjavasdk.models.parameters.CreateChannelParams;
import com.jrodmanu.mattermostjavasdk.models.parameters.SearchChannelsParams;

public class ChannelsService extends MattermostService {

    public ChannelsService(MattermostProcessor processor) {
        super(processor);
    }

    public Channel[] searchChannels(SearchChannelsParams params) throws MattermostException {
        if (params.teamId == null) {
            params.teamId = processor.getDefaultTeamId();
        }
        String route = String.format("/teams/%s/channels/search", params.teamId);
        return processor.httpPost(route, params.getSearchTermBody(), Channel[].class);
    }

    public Channel createChannel(CreateChannelParams params) throws MattermostException {
        if (params.teamId == null) {
            params.teamId = processor.getDefaultTeamId();
        }
        return processor.httpPost("/channels", params.getCreateChannelBody(), Channel.class);
    }
}
