# mattermost-java-sdk
Warning, this project is in the early stages of development

Example to send a message:
```
MattermostClient client = new MattermostClient.Builder("https://mattermost.winwholesale.com/api/v4")
        .setAccessToken("7piicur1jidkbxcrpxf9p98jae")
        .setDefaultTeam("winsupply")
        .build();

String channelId = client.channels.searchChannels(new SearchChannelsParams.Builder("goodlair").build()).body[0].id;

MattermostResponse<CreatePostResponse> createPostResponse = client.posts.createPost(
        new CreatePostParams.Builder("There is no need to be afraid")
                .setChannelId(channelId)
                .build()
);
```