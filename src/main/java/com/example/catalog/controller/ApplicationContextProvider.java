package com.example.catalog.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {
    private ApplicationContext CONTEXT;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("context aware1"+applicationContext.getBean("dataSource"));
        CONTEXT = applicationContext;
    }

    public Object getBean(String beanName) {
        return CONTEXT.getBean(beanName);
    }
}

