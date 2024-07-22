package by.gvu.client.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
@Slf4j
public class SimpleService {
    private final RestClient restClient;

    public String sayHelloFromServer() {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder.path("/exception").build())
                .retrieve()
                .onStatus(HttpStatusCode::isError, (request, response) -> log.error("handle error [{}]", response.getStatusCode()))
                .body(String.class);
    }
}
