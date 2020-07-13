package com.jrodmanu.mattermostjavasdk.models.bodies;

/**
 * Object used to represent body to send to Mattermost API to search for teams and get paginated results
 */
public class SearchTeamsPaginatedBody {
    public String term;
    public Integer page;
    public Integer perPage;

    /**
     * SearchTeamsPaginated constructor
     * @param term the search term to find the teams with
     * @param page the page of the search results to get
     * @param perPage the results per page
     */
    public SearchTeamsPaginatedBody(String term, Integer page, Integer perPage) {
        this.term = term;
        this.page = page;
        this.perPage = perPage;
    }
}
