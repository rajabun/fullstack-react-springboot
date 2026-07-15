package com.eazybytes.eazystore.scopes;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

//@SessionScope the bean will be created for each user session

@Component
@ApplicationScope @Getter
@Slf4j
public class ApplicationScopedBean {
    private int visitorCount;

    public void incrementVisitorCount() {
        visitorCount++;
    }

    public ApplicationScopedBean() {
        log.info("SessionScopedBean initialized");
    }

}