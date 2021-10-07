package com.iljasstan.properties;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

public class TestCredentials {
    public static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);

    @Test
    void testCredentials() {
        String login = credentials.login();
        String password = credentials.password();

    }
}
