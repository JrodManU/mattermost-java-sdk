package com.jrodmanu.mattermostjavasdk.models.parameters;

import com.jrodmanu.mattermostjavasdk.models.bodies.SearchTermBody;

public class SearchChannelsParams {

    public static class Builder {
        private final String term;
        private String teamId;

        public Builder(String term) {
            this.term = term;
        }
        public SearchChannelsParams.Builder setTeamId(String teamId) {
            this.teamId = teamId;
            return this;
        }
        public SearchChannelsParams build() {
            SearchChannelsParams searchChannelsParams = new SearchChannelsParams();
            searchChannelsParams.term = term;
            searchChannelsParams.teamId = teamId;
            return searchChannelsParams;
        }
    }

    public String term;
    public String teamId;

    private SearchChannelsParams() {

    }

    public SearchTermBody getSearchTermBody() {
        return new SearchTermBody(term);
    }
}
