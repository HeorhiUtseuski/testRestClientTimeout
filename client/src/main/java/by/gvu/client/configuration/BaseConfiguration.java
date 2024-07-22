package by.gvu.client.configuration;

import org.springframework.boot.web.client.ClientHttpRequestFactories;
import org.springframework.boot.web.client.ClientHttpRequestFactorySettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import java.time.Duration;

@Configuration
public class BaseConfiguration {

    @Bean
    public RestClient restClient(RestClient.Builder builder) {
        return builder
                .baseUrl("http://localhost:8082")
                .requestFactory(requestFactory())
                .build();
    }

    private ClientHttpRequestFactory requestFactory() {
        ClientHttpRequestFactorySettings requestFactorySettings = ClientHttpRequestFactorySettings.DEFAULTS
                .withConnectTimeout(Duration.ofSeconds(2))
                .withReadTimeout(Duration.ofSeconds(1));

        return new BufferingClientHttpRequestFactory(ClientHttpRequestFactories.get(requestFactorySettings));
    }
}
