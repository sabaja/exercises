package com.js.exercises.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ConfigPropertiesTest {

    @Autowired
    private ConfigPropertiesEvolution configPropertiesEvolution;

    @Test
    public void testConfiguration() {
        assertEquals("host.name", configPropertiesEvolution.getHostName());
        assertEquals(9090, configPropertiesEvolution.getPort());
        assertEquals("a_a", configPropertiesEvolution.getFrom());
        assertEquals("a_a", configPropertiesEvolution.getFrom());

        assertEquals("admin@mail.com", configPropertiesEvolution.getDefaultRecipients().getFirst());
        assertEquals("owner@mail.com", configPropertiesEvolution.getDefaultRecipients().get(1));

        assertTrue(Boolean.parseBoolean(configPropertiesEvolution.getAdditionalHeaders().get("redelivery")));
        assertTrue(Boolean.parseBoolean(configPropertiesEvolution.getAdditionalHeaders().get("secure")));

        assertEquals("john", configPropertiesEvolution.getCredentials().getUsername());
        assertEquals("password", configPropertiesEvolution.getCredentials().getPassword());
        assertEquals("SHA1", configPropertiesEvolution.getCredentials().getAuthMethod());


    }
}