package com.kawa.springb.base.service;

import org.springframework.stereotype.Service;

import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;

@Service
public class AGIService {

    private final AGIAssistant assistant;

    public AGIService (OpenAiChatModel model) {
         assistant = AiServices.create(AGIAssistant.class, model);
    }

    public String chat(String message) {
        return assistant.chat(message);
    }

    
}
