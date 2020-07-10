# mattermost-java-sdk
Warning, this project is in the early stages of development

Example to send a message:
```
try {
    MattermostClient client = new MattermostClient.Builder("https://your-mattermost.com/api/v4")
            .setAccessToken("your access token")
            .setDefaultTeam("your team")
            .build();

    String channelId = client.channels.searchChannels(new SearchChannelsParams.Builder("your channel").build())[0].id;

    CreatePostResponse createPostResponse = client.posts.createPost(
            new CreatePostParams.Builder("There is no need to be afraid")
                    .setChannelId(channelId)
                    .build()
    );
} catch (MattermostException e) {
    e.printStackTrace();
}
```
