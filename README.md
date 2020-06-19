# mattermost-java-sdk
Warning, this project is in the early stages of development

Example to send a message:
```
MattermostClient client = new MattermostClient.Builder("https://your-mattermost-url.com/api/v4")
        .setAccessToken("your access token")
        .setDefaultTeam("your team name") //optional
        .build();

String channelId = client.channels.searchChannels(
    new SearchChannelsParams.Builder("goodlair").build()
)[0].id;

CreatePostResponse createPostResponse = client.posts.createPost(
        new CreatePostParams.Builder("There is no need to be afraid")
                .setChannelId(channelId)
                .build()
);
```