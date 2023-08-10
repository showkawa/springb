package com.kawa.springb.drools.config;

import com.kawa.springb.drools.runner.DMNRunner;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class DroolsEngineConfig {

    @Value("${brianhuang.dmn.nameSpace.bitbucket}")
    private String bitbucketNameSpace;

    @Value("${brianhuang.dmn.modelName.bitbucket}")
    private String bitbucketModelName;

    @Value("${brianhuang.dmn.nameSpace.openshift}")
    private String openshiftNameSpace;

    @Value("${brianhuang.dmn.modelName.openshift}")
    private String openshiftModelName;

    @Bean
    @ConditionalOnMissingBean(KieContainer.class)
    public KieContainer kieContainer(){
        KieServices kieServices = KieServices.Factory.get();
        return kieServices.getKieClasspathContainer();
    }

    @Bean
    @DependsOn({"kieContainer"})
    public DMNRunner bitbucketDMNRunner(KieContainer kieContainer){
       return new DMNRunner(kieContainer,bitbucketNameSpace,bitbucketModelName);
    }

    @Bean
    @DependsOn({"kieContainer"})
    public DMNRunner openshiftDMNRunner(KieContainer kieContainer){
        return new DMNRunner(kieContainer,openshiftNameSpace,openshiftModelName);
    }



}
