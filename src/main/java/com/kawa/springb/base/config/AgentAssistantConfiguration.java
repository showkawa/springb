package com.kawa.springb.base.config;


import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class AgentAssistantConfiguration {
    @Value("${brianhuang.llms.base-url}")
    private String baseUrl;

    @Value("${brianhuang.llms.api-key}")
    private String apiKey;

    @Value("${brianhuang.llms.model-name}")
    private String modelName;

    @Value("${brianhuang.llms.temperature}")
    private double temperature;

    @Value("${brianhuang.llms.timeout}")
    private int timeout;

    @Value("${brianhuang.llms.log.requests}")
    private boolean logRequests;

    @Value("${brianhuang.llms.log.responses}")
    private boolean logResponses;

    @Bean
    public OpenAiChatModel getOpenAiChatModel() {
        return OpenAiChatModel.builder()
                .baseUrl(baseUrl)
                .apiKey(apiKey)
                .modelName(modelName)
                .temperature(temperature)
                .timeout(Duration.ofSeconds(timeout))
                .logRequests(logRequests)
                .logResponses(logResponses)
                .build();
    }
}
