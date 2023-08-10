package com.kawa.springb.drools.runner;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieRuntimeFactory;
import org.kie.dmn.api.core.DMNModel;
import org.kie.dmn.api.core.DMNRuntime;

import java.util.HashMap;
import java.util.Map;

public class DMNRunner {
    private DMNRuntime dmnRuntime;
    private DMNModel dmnModel;

    public DMNRunner(KieContainer kieContainer, String nameSpace, String modelName) {
        this.dmnRuntime = KieRuntimeFactory.of(kieContainer.getKieBase()).get(DMNRuntime.class);
        this.dmnModel = dmnRuntime.getModel(nameSpace, modelName);
    }

    public Map<String, Object> execute(Map<String, Object> input) {
        var dmnContext = dmnRuntime.newContext();
        input.entrySet().forEach(et -> dmnContext.set(et.getKey(), et.getValue()));
        var dmnResult = dmnRuntime.evaluateAll(dmnModel, dmnContext);
        var output = new HashMap<String, Object>();
        dmnResult.getDecisionResults().forEach(
                dr -> output.put(dr.getDecisionName(), dr.getResult())
        );
        return output;
    }

}
