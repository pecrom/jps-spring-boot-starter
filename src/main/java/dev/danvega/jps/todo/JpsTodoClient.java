package dev.danvega.jps.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClient;

import java.util.List;


public class JpsTodoClient {

    private static final Logger log = LoggerFactory.getLogger(JpsTodoClient.class);
    private final RestClient restClient;

    public JpsTodoClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<Todo> findAll() {
        return List.of();
    }


}
