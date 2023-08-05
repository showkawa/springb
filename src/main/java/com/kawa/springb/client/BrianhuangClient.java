package com.kawa.springb.client;


import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("/v1/get/")
public interface BrianhuangClient {

    @GetExchange()
    public String v1Get();
}
