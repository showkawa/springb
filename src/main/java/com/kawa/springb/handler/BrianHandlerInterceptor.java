package com.kawa.springb.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class BrianHandlerInterceptor implements HandlerInterceptor {

    private AtomicReference<String> requestId = new AtomicReference<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        var rId = request.getHeader("x-request-id");
        var preVal = requestId.get();
        if (preVal !=null && !preVal.isBlank()) {
            requestId.compareAndSet(preVal,rId);
        } else {
            requestId.set(rId);
        }
        log.info("<<< request >>>: requestID:{},upStream:{}", requestId.get(), request.getRemoteHost() + ":" + request.getRemotePort());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("<<< response >>>:requestID:{},statusCode:{}", requestId.get(), response.getStatus());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
