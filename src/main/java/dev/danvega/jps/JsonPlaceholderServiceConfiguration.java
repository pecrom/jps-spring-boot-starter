package dev.danvega.jps;

import dev.danvega.jps.todo.JpsTodoClient;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

import java.util.logging.Logger;

@AutoConfiguration
@EnableConfigurationProperties(JsonPlaceholderServiceProperties.class)
public class JsonPlaceholderServiceConfiguration {

    private static final Logger log = Logger.getLogger(JsonPlaceholderServiceConfiguration.class.getName());
    private final JsonPlaceholderServiceProperties jpsProperties;

    public JsonPlaceholderServiceConfiguration(JsonPlaceholderServiceProperties jpsProperties) {
        this.jpsProperties = jpsProperties;
    }

    @Bean(name = "jsonPlaceholderRestClient")
    RestClient restClient(RestClient.Builder builder) {
        return builder
                .baseUrl(jpsProperties.baseUrl())
                .build();
    }

    @Bean
    JpsTodoClient jpsTodoClient(RestClient restClient) {
        return new JpsTodoClient(restClient);
    }
}
