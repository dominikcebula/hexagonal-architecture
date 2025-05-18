package com.dominikcebula.samples.loans.application.domain.model.support.spring;

import org.mockito.Mockito;
import org.springframework.beans.factory.BeanFactory;

public class BeanProviderMock {
    public static void setUp() {
        if (BeanProvider.beanFactory == null)
            BeanProvider.beanFactory = Mockito.mock(BeanFactory.class);
    }

    public static <T> void registerBean(Class<T> type, T bean) {
        Mockito.when(BeanProvider.beanFactory.getBean(type)).thenReturn(bean);
    }

    public static void tearDown() {
        BeanProvider.beanFactory = null;
    }
}