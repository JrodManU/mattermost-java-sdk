package com.jrodmanu.mattermostjavasdk.services;

import com.jrodmanu.mattermostjavasdk.MattermostProcessor;
import com.jrodmanu.mattermostjavasdk.models.common.Channel;
import com.jrodmanu.mattermostjavasdk.models.exceptions.MattermostException;
import com.jrodmanu.mattermostjavasdk.models.parameters.CreateChannelParams;
import com.jrodmanu.mattermostjavasdk.models.parameters.SearchChannelsParams;

/**
 * Service to handle all requests involving channels
 */
public class ChannelsService extends MattermostService {

    /**
     * Constructor for ChannelsService
     * @param processor used to process each request
     */
    public ChannelsService(MattermostProcessor processor) {
        super(processor);
    }

    /**
     * Searches for channels. Will use default teamId if none provided.
     * @param params a SearchChannelsParams object
     * @return returns a list of channels found. List will be empty if none are found.
     * @throws MattermostException when the request fails
     */
    public Channel[] searchChannels(SearchChannelsParams params) throws MattermostException {
        if (params.teamId == null) {
            params.teamId = processor.getDefaultTeamId();
        }
        String route = String.format("/teams/%s/channels/search", params.teamId);
        return processor.httpPost(route, params.getSearchTermBody(), Channel[].class);
    }

    /**
     * Creates a new channel. Will use the default teamId if none provided.
     * @param params a CreateChannelParams object
     * @return returns the channel created.
     * @throws MattermostException when the request fails
     */
    public Channel createChannel(CreateChannelParams params) throws MattermostException {
        if (params.teamId == null) {
            params.teamId = processor.getDefaultTeamId();
        }
        return processor.httpPost("/channels", params.getCreateChannelBody(), Channel.class);
    }
}
