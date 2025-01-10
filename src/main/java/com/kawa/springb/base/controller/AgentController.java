package com.kawa.springb.base.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/chat")
@Slf4j
public class AgentController {

    private final ChatClient chatClient;

    public AgentController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();;
    }

    @PostMapping("/test")
    public ResponseEntity<String> testChat(@RequestBody String request) throws JSONException {
        String res = this.chatClient.prompt()
                .user(request)
                .call()
                .content();
        return new ResponseEntity<>(res, HttpStatus.OK);
//        ChatResponse chatResponse = chatClient.prompt()
//                .user(request)
//                .call()
//                .chatResponse();

//        return new ResponseEntity<>(chatResponse, HttpStatus.OK);

    }
}
