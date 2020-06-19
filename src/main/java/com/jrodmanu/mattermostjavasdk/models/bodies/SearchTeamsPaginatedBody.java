package com.jrodmanu.mattermostjavasdk.models.bodies;

public class SearchTeamsPaginatedBody {
    public String term;
    public Integer page;
    public Integer perPage;

    public SearchTeamsPaginatedBody(String term, Integer page, Integer perPage) {
        this.term = term;
        this.page = page;
        this.perPage = perPage;
    }
}
