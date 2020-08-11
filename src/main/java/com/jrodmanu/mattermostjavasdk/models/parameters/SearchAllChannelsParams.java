package com.jrodmanu.mattermostjavasdk.models.parameters;

/**
 * Object passed to the mattermost-java-sdk to search all channels
 */
public class SearchAllChannelsParams {
    /**
     * Builder for SearchAllChannelsParams
     */
    public static class Builder {

        private final String term;
        private String notAssociatedToGroup;
        private boolean excludeDefaultChannels;
        private String[] teamIds;
        private boolean groupConstrained;
        private boolean _public;
        private boolean _private;
        private boolean deleted;

        /**
         * Constructor the the SearchAllChannelsParams Builder
         * @param term the search term to find a channel
         */
        public Builder(String term) {
            this.term = term;
        }

        /**
         * @param notAssociatedToGroup the channel id to send the post in
         * @return the builder
         */
        public SearchAllChannelsParams.Builder setNotAssociatedToGroup(String notAssociatedToGroup) {
            this.notAssociatedToGroup = notAssociatedToGroup;
            return this;
        }

        /**
         * @param excludeDefaultChannels whether the user should be set to online when making the post
         * @return the builder
         */
        public SearchAllChannelsParams.Builder setExcludeDefaultChannels(boolean excludeDefaultChannels) {
            this.excludeDefaultChannels = excludeDefaultChannels;
            return this;
        }

        /**
         * @param teamIds fileId's to add to the post
         * @return the builder
         */
        public SearchAllChannelsParams.Builder setTeamIds(String[] teamIds) {
            this.teamIds = teamIds;
            return this;
        }

        /**
         * @param groupConstrained additional properties for the post
         * @return the builder
         */
        public SearchAllChannelsParams.Builder setGroupConstrained(boolean groupConstrained) {
            this.groupConstrained = groupConstrained;
            return this;
        }

        /**
         * @param _public additional properties for the post
         * @return the builder
         */
        public SearchAllChannelsParams.Builder setPublic(boolean _public) {
            this._public = _public;
            return this;
        }

        /**
         * @param _private additional properties for the post
         * @return the builder
         */
        public SearchAllChannelsParams.Builder setPrivate(boolean _private) {
            this._private = _private;
            return this;
        }

        /**
         * @param deleted additional properties for the post
         * @return the builder
         */
        public SearchAllChannelsParams.Builder setDeleted(boolean deleted) {
            this.deleted = deleted;
            return this;
        }

        /**
         * @return a SearchAllChannelsParams object from the data given
         */
        public SearchAllChannelsParams build() {
            SearchAllChannelsParams searchAllChannelsParams = new SearchAllChannelsParams();
            searchAllChannelsParams.term = term;
            searchAllChannelsParams.notAssociatedToGroup = notAssociatedToGroup;
            searchAllChannelsParams.excludeDefaultChannels = excludeDefaultChannels;
            searchAllChannelsParams.teamIds = teamIds;
            searchAllChannelsParams.groupConstrained = groupConstrained;
            searchAllChannelsParams._public = _public;
            searchAllChannelsParams._private = _private;
            searchAllChannelsParams.deleted = deleted;
            return searchAllChannelsParams;
        }
    }

    public String term;
    public String notAssociatedToGroup;
    public boolean excludeDefaultChannels;
    public String[] teamIds;
    public boolean groupConstrained;
    public boolean _public;
    public boolean _private;
    public boolean deleted;

    /**
     * Private because we are using a Builder
     */
    private SearchAllChannelsParams() {

    }
}
