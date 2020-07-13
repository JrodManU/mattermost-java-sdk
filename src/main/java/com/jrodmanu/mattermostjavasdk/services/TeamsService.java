package com.jrodmanu.mattermostjavasdk.services;

import com.jrodmanu.mattermostjavasdk.MattermostProcessor;
import com.jrodmanu.mattermostjavasdk.models.bodies.SearchTermBody;
import com.jrodmanu.mattermostjavasdk.models.common.Team;
import com.jrodmanu.mattermostjavasdk.models.exceptions.MattermostException;
import com.jrodmanu.mattermostjavasdk.models.parameters.SearchTeamsPaginatedParams;
import com.jrodmanu.mattermostjavasdk.models.responses.SearchTeamsPaginatedResponse;

/**
 * Service to handle all team related requests
 */
public class TeamsService extends MattermostService {

    /**
     * TeamSearvice constructor
     * @param processor used to process all requests
     */
    public TeamsService(MattermostProcessor processor) {
        super(processor);
    }

    /**
     * Searches for teams with pagination
     * @param params a SearchTeamsPaginatedParams object
     * @return returns a reponse object that has the results of the search and is paginated
     * @throws MattermostException when the request fails
     */
    public SearchTeamsPaginatedResponse searchTeamsPaginated(SearchTeamsPaginatedParams params) throws MattermostException {
        return processor.httpPost("/teams/search", params.getSearchTeamsPaginatedBody(), SearchTeamsPaginatedResponse.class);
    }

    /**
     * Searches for teams without pagination
     * @param term the term to search for
     * @return returns an array of teams. Empty if none are found
     * @throws MattermostException when the request fails
     */
    public Team[] searchTeams(String term) throws MattermostException {
        return processor.httpPost("/teams/search", new SearchTermBody(term), Team[].class);
    }

}
