package com.jrodmanu.mattermostjavasdk.models.parameters;

import com.jrodmanu.mattermostjavasdk.models.bodies.SearchTeamsPaginatedBody;

/**
 * Object is passed to the mattermost-java-sdk to search for teams and get paginated results
 */
public class SearchTeamsPaginatedParams {

    /**
     * Builder for SearchTeamsPaginatedParams
     */
    public static class Builder {
        private final String term;
        private Integer page;
        private Integer perPage;

        /**
         * Constructor for SearchTeamsPaginatedParams Builder
         * @param term the search term to find the team
         */
        public Builder(String term) {
            this.term = term;
        }

        /**
         * @param page the index of the page to get
         * @return the builder
         */
        public Builder setPage(Integer page) {
            this.page = page;
            return this;
        }

        /**
         * @param perPage number of results per page
         * @return the builder
         */
        public Builder setPerPage(Integer perPage) {
            this.perPage = perPage;
            return this;
        }

        /**
         * @return a SearchTermPaginatedParams created from the data given
         */
        public SearchTeamsPaginatedParams build() {
            SearchTeamsPaginatedParams searchTeamsPaginatedParams = new SearchTeamsPaginatedParams();
            searchTeamsPaginatedParams.term = term;
            searchTeamsPaginatedParams.page = page;
            searchTeamsPaginatedParams.perPage = perPage;
            return searchTeamsPaginatedParams;
        }
    }

    public String term;
    public Integer page;
    public Integer perPage;

    /**
     * Private because we are using a Builder
     */
    private SearchTeamsPaginatedParams() {

    }

    /**
     * @return returns a SearchTeamsPaginatedBody that can be sent to the Mattermost API
     */
    public SearchTeamsPaginatedBody getSearchTeamsPaginatedBody() {
        return new SearchTeamsPaginatedBody(term, page, perPage);
    }

}
