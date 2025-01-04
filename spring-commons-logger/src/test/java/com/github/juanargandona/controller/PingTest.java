package com.github.juanargandona.controller;

import com.github.juanargandona.TestApplication;
import com.github.juanargandona.configuration.PropertiesLogger;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = TestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PingTest {

    @LocalServerPort
    private int port;

    @Autowired
    private PropertiesLogger propertiesLogger;

    @Value("${spring.commons.logger.trace.id}")
    private String traceKey;

    @Value("${spring.commons.logger.app.name}")
    private String appName;

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void contextLoad() throws Exception {
        String result = this.restTemplate.getForEntity("http://localhost:" + port + "/ping", String.class).getBody();
        assertThat(result, Matchers.equalTo("pong"));
        assertEquals(appName, propertiesLogger.getPropetiesToShow().get(PropertiesLogger.APP_NAME));
        //two twice for if (isEmpty)
        assertEquals(appName, propertiesLogger.getPropetiesToShow().get(PropertiesLogger.APP_NAME));
    }

    @Test
    public void contextLoadKey() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.put(traceKey, Arrays.asList("key"));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:" + port + "/ping", HttpMethod.GET, request, String.class);
            assertThat(response.getBody(), Matchers.equalTo("pong"));
    }
}