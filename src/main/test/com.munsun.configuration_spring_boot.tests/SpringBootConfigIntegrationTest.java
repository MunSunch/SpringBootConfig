package com.munsun.configuration_spring_boot.tests;

import com.munsun.configuration_spring_boot._app.ConfigurationSpringBootAppApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(classes = ConfigurationSpringBootAppApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootConfigIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Container
    private GenericContainer<?> devapp =
            new GenericContainer<>("devapp")
                    .withExposedPorts(8080);
    @Container
    private GenericContainer<?> prodapp =
            new GenericContainer<>("prodapp")
                    .withExposedPorts(8081);

    @Test
    public void getProfileDev() {
        int port = devapp.getMappedPort(8080);
        String url = "http://localhost:"+port+"/profile";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        String expected = "Current profile is dev";
        String actual = response.getBody();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getProfileProd() {
        int port = prodapp.getMappedPort(8081);
        String url = "http://localhost:"+port+"/profile";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        String expected = "Current profile is production";
        String actual = response.getBody();
        Assertions.assertEquals(expected, actual);
    }
}
