package com.jrodmanu.mattermostjavasdk.models.responses;

import com.jrodmanu.mattermostjavasdk.models.common.Team;

/**
 * Represents a response to searching for paginated teams from the Mattermost API
 */
public class SearchTeamsPaginatedResponse {
    public Team[] teams;
    public int totalCount;
}
