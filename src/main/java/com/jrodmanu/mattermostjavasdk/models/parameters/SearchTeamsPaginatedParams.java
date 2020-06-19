package com.jrodmanu.mattermostjavasdk.models.parameters;

import com.jrodmanu.mattermostjavasdk.models.bodies.SearchTeamsPaginatedBody;

public class SearchTeamsPaginatedParams {

    public static class Builder {
        private final String term;
        private Integer page;
        private Integer perPage;

        public Builder(String term) {
            this.term = term;
        }
        public Builder setPage(Integer page) {
            this.page = page;
            return this;
        }
        public Builder setPerPage(Integer perPage) {
            this.perPage = perPage;
            return this;
        }
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

    private SearchTeamsPaginatedParams() {

    }

    public SearchTeamsPaginatedBody getSearchTeamsPaginatedBody() {
        return new SearchTeamsPaginatedBody(term, page, perPage);
    }

}
