package com.kawa.springb.config;

import com.kawa.springb.client.BrianhuangClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpClientConfig {

    @Value("${brianhuang.client.url}")
    private String brianhuangClientUrl;

    @Bean
    public BrianhuangClient getBrianhuangClient(){
        WebClient brianhuangClient = WebClient.builder().baseUrl(brianhuangClientUrl).build();
        HttpServiceProxyFactory serviceProxyFactory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(brianhuangClient)).build();
        return serviceProxyFactory.createClient(BrianhuangClient.class);
    }
}
