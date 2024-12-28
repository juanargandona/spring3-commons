package com.github.juanargandona.exceptions.tests;

import com.github.juanargandona.exceptions.TestApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = TestApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ExceptionCodeTest {
    @LocalServerPort
    private int port;

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void permissionDenied() {
        assertThrows(Forbidden.class, () -> this.restTemplate.exchange("http://localhost:" + port + "/permissionDenied",
                HttpMethod.POST, null,
                Object.class), "");

    }

    @Test
    public void forbbiden() {
        assertThrows(Forbidden.class, () -> this.restTemplate.exchange("http://localhost:" + port + "/forbbiden", HttpMethod.POST, null, Object.class));
    }

    @Test
    public void conflict() {
        assertThrows(HttpClientErrorException.class, () -> this.restTemplate.exchange("http://localhost:" + port + "/conflict", HttpMethod.POST, null, Object.class));
    }


    @Test
    public void badRequest() throws Exception {
        assertThrows(BadRequest.class, () -> this.restTemplate.exchange("http://localhost:" + port + "/badrequest", HttpMethod.POST, null, Object.class));
    }

    @Test
    public void notfound() throws Exception {
        assertThrows(NotFound.class, () -> this.restTemplate.exchange("http://localhost:" + port + "/notfound", HttpMethod.POST, null, Object.class));
    }
}