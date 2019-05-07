package com.example.catalog;

import com.example.catalog.controller.ApplicationContextProvider;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class CatalogprojectApplication implements ApplicationContextAware, ApplicationListener<ApplicationReadyEvent> {

    public static void main(String[] args) {
        SpringApplication.run(CatalogprojectApplication.class, args);
    }

    @Autowired
    ApplicationContextProvider applicationContextProvider;

    ApplicationContext ac;



    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        applicationContextProvider = new ApplicationContextProvider();
        applicationContextProvider.setApplicationContext(ac);
        System.out.println("Init"+applicationContextProvider.getBean("dataSource"));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationContext.getBeanDefinitionNames();
        Arrays.asList(applicationContext.getBeanDefinitionNames()).forEach(s -> System.out.println(s));
        System.out.println(applicationContext.getBeanDefinitionCount());
        ac=applicationContext;
    }
}
