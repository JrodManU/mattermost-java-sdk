package com.jrodmanu.mattermostjavasdk.models.parameters;

import com.jrodmanu.mattermostjavasdk.models.bodies.SearchTermBody;

/**
 * Object to pass to the mattermost-java-sdk to to search for a channel
 */
public class SearchChannelsParams {

    /**
     * Builder class for SearchChannelParams
     */
    public static class Builder {
        private final String term;
        private String teamId;

        /**
         * Constructor for SearchChannelParams Builder
         * @param term the search term to find the channel
         */
        public Builder(String term) {
            this.term = term;
        }

        /**
         * @param teamId the teamId of the team that owns the channel you are looking for
         * @return the builder
         */
        public SearchChannelsParams.Builder setTeamId(String teamId) {
            this.teamId = teamId;
            return this;
        }

        /**
         * @return a SearchChannelsParams object created from the data given
         */
        public SearchChannelsParams build() {
            SearchChannelsParams searchChannelsParams = new SearchChannelsParams();
            searchChannelsParams.term = term;
            searchChannelsParams.teamId = teamId;
            return searchChannelsParams;
        }
    }

    public String term;
    public String teamId;

    /**
     * private because we are using a builder
     */
    private SearchChannelsParams() {

    }

    /**
     * @return returns a SearchTermBody that can be send to the Mattermost API
     */
    public SearchTermBody getSearchTermBody() {
        return new SearchTermBody(term);
    }
}
