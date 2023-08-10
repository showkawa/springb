package com.kawa.springb.drools.service;


import com.kawa.springb.drools.runner.DMNRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class DmnCommonService {

    @Autowired
    private Map<String, DMNRunner> dmnRunnerMap;

    public Map<String, Object> baseCheck(String key,Map<String,Object> input){
        var output = new AtomicReference<>(new HashMap<String, Object>());
        dmnRunnerMap.forEach((name, dmnRunner) -> {
            if(name.equals(key)){
               output.set((HashMap<String, Object>) dmnRunner.execute(input));
            }
        });
        return output.get();
    }
}
