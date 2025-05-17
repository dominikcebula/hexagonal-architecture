package com.dominikcebula.samples.loans.application.domain.model.support.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanProvider implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        BeanProvider.context = context;
    }

    public static <T> T getBean(Class<T> requiredType) {
        if (context == null) {
            throw new IllegalStateException("ApplicationContext is not initialized yet.");
        }
        return context.getBean(requiredType);
    }
}
