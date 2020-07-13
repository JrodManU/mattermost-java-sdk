package com.jrodmanu.mattermostjavasdk.models.bodies;

/**
 * Object represents body sent to the Mattermost API for anything that just requires a search term
 */
public class SearchTermBody {
    public String term;

    /**
     * SearchTermBody constructor
      * @param term the term to search for something with
     */
    public SearchTermBody(String term) {
        this.term = term;
    }
}
