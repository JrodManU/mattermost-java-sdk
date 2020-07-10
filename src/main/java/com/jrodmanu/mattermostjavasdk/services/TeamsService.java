package com.jrodmanu.mattermostjavasdk.services;

import com.jrodmanu.mattermostjavasdk.MattermostProcessor;
import com.jrodmanu.mattermostjavasdk.models.bodies.SearchTermBody;
import com.jrodmanu.mattermostjavasdk.models.common.Team;
import com.jrodmanu.mattermostjavasdk.models.exceptions.MattermostException;
import com.jrodmanu.mattermostjavasdk.models.parameters.SearchTeamsPaginatedParams;
import com.jrodmanu.mattermostjavasdk.models.responses.SearchTeamsPaginatedResponse;

public class TeamsService extends MattermostService {
    public TeamsService(MattermostProcessor processor) {
        super(processor);
    }

    public SearchTeamsPaginatedResponse searchTeamsPaginated(SearchTeamsPaginatedParams params) throws MattermostException {
        return processor.httpPost("/teams/search", params.getSearchTeamsPaginatedBody(), SearchTeamsPaginatedResponse.class);
    }

    public Team[] searchTeams(String term) throws MattermostException {
        return processor.httpPost("/teams/search", new SearchTermBody(term), Team[].class);
    }

}
