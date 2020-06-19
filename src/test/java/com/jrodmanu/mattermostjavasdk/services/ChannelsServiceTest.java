package com.jrodmanu.mattermostjavasdk.services;

import com.jrodmanu.mattermostjavasdk.MattermostClient;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChannelsServiceTest {

    private static MattermostClient client;

    @BeforeAll
    static void setup() {
        client = new MattermostClient("https://mattermost.testing.com/api/v4", "bestaccestokenever");
    }

    @Test
    void searchChannelsTest() {
        assertEquals(1, 1);
    }
}
