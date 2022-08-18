package com.sm.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class DroolConfig {

    private KieServices kieServices = KieServices.Factory.get();

    private KieFileSystem getKieFileSystem() throws IOException {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource("order_offer.drl"));
        kieFileSystem.write(ResourceFactory.newClassPathResource("customer_offer.xls"));
        return kieFileSystem;
    }


    @Bean
    public KieContainer getKieContainer() throws IOException {
        createKieRepository();
        KieBuilder kb = kieServices.newKieBuilder(getKieFileSystem());
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();
        KieContainer kContainer = kieServices.newKieContainer(kieModule.getReleaseId());
        return kContainer;
    }

    private void createKieRepository() {
        final KieRepository kieRepository = kieServices.getRepository();
        kieRepository.addKieModule(() -> kieRepository.getDefaultReleaseId());
    }

    @Bean
    public KieSession getKieSession() throws IOException {
        return getKieContainer().newKieSession();
    }

}
