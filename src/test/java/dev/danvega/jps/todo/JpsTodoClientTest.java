package dev.danvega.jps.todo;

import dev.danvega.jps.JsonPlaceholderServiceConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.autoconfigure.web.client.RestClientAutoConfiguration;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;


class JpsTodoClientTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(JsonPlaceholderServiceConfiguration.class, RestClientAutoConfiguration.class));

    @Test
    void shouldContainTodoRestClientBean() {
        contextRunner.run(context -> {
            assertTrue(context.containsBean("jsonPlaceholderRestClient"));
            assertTrue(context.containsBean("jpsTodoClient"));
        });
    }
}