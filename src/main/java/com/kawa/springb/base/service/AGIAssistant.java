package com.kawa.springb.base.service;

import dev.langchain4j.service.SystemMessage;

public interface AGIAssistant {
    @SystemMessage("You are a helpful assistant.")
    String chat(String message);
}
