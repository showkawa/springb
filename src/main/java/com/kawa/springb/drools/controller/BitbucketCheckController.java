package com.kawa.springb.drools.controller;

import com.kawa.springb.drools.bean.FlywayNameRequest;
import com.kawa.springb.drools.service.DmnCommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/bitbucket")
public class BitbucketCheckController {


    @Autowired
    private DmnCommonService dmnCommonService;

    @PostMapping("/flyway/nameFormatCheck")
    public ResponseEntity<Map<String, Object>> nameFormatCheck(@RequestBody FlywayNameRequest request) {
        var input = new HashMap<String, Object>();
        input.put("fileName", request.getName());
        Map<String, Object> output = dmnCommonService.baseCheck(request.getModelName(), input);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }
}
