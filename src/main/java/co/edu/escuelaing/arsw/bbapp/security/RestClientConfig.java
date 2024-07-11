package co.edu.escuelaing.arsw.bbapp.security;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.GeneralSecurityException;

@Configuration
public class RestClientConfig {

    @Bean
    public RestTemplate restTemplate() throws GeneralSecurityException, IOException {
        // Load your SSL context and create an SSLConnectionSocketFactory
        SSLContext sslContext = SSLContextBuilder.create().build();
        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);

        // Create HttpClient with the custom SSL socket factory
        HttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(socketFactory)
                .build();

        // Create HttpComponentsClientHttpRequestFactory with the custom HttpClient
        HttpComponentsClientHttpRequestFactory factory =
                new HttpComponentsClientHttpRequestFactory();

        // Return a new RestTemplate instance configured with the custom factory
        return new RestTemplate(factory);
    }
}
