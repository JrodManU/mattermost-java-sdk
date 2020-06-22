package com.jrodmanu.mattermostjavasdk.services;

import com.jrodmanu.mattermostjavasdk.MattermostProcessor;
import com.jrodmanu.mattermostjavasdk.models.bodies.SearchTermBody;
import com.jrodmanu.mattermostjavasdk.models.common.Team;
import com.jrodmanu.mattermostjavasdk.models.parameters.SearchTeamsPaginatedParams;
import com.jrodmanu.mattermostjavasdk.models.responses.MattermostResponse;
import com.jrodmanu.mattermostjavasdk.models.responses.SearchTeamsPaginatedResponse;

public class TeamsService extends MattermostService {
    public TeamsService(MattermostProcessor processor) {
        super(processor);
    }

    public MattermostResponse<SearchTeamsPaginatedResponse> searchTeamsPaginated(SearchTeamsPaginatedParams params) {
        return processor.httpPost("/teams/search", params.getSearchTeamsPaginatedBody(), SearchTeamsPaginatedResponse.class);
    }

    public MattermostResponse<Team[]> searchTeams(String term) {
        return processor.httpPost("/teams/search", new SearchTermBody(term), Team[].class);
    }

}
