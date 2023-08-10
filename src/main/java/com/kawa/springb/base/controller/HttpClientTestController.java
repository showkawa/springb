package com.kawa.springb.base.controller;


import com.kawa.springb.base.client.BrianhuangClient;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class HttpClientTestController {

    @Autowired
    private BrianhuangClient client;

    @GetMapping("/request-id")
    public ResponseEntity<String> getRequestId(HttpServletRequest request) throws JSONException {
        return new ResponseEntity<>(request.getHeader("x-request-id"), HttpStatus.OK);
    }
}
