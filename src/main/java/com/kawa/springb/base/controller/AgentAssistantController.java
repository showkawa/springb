package com.kawa.springb.base.controller;

import com.kawa.springb.base.service.AGIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/agi")
@Slf4j
public class AgentAssistantController {

    @Autowired
    private AGIService agiService;

    @PostMapping("/test")
    public ResponseEntity<String> agiChat(@RequestBody String request) throws JSONException {
        String res = this.agiService.chat(request);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
