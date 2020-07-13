# mattermost-java-sdk
Warning, this project is in the early stages of development

I am in the process of adding it to maven central

This project relies on GSON
```
implementation 'com.google.code.gson:gson:2.+'
```

Example to send a message:
```
try {
    MattermostClient client = new MattermostClient.Builder("https://your-mattermost.com/api/v4")
            .setAccessToken("your access token")
            .setDefaultTeam("your team")
            .build();

    String channelId = client.channels.searchChannels(new SearchChannelsParams.Builder("your channel").build())[0].id;

    Post post = client.posts.createPost(
            new CreatePostParams.Builder("There is no need to be afraid")
                    .setChannelId(channelId)
                    .build()
    );
} catch (MattermostException e) {
    e.printStackTrace();
}
```
