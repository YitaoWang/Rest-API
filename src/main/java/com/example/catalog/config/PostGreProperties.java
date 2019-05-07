package com.example.catalog.config;

import com.example.catalog.pojo.DataBaseInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class PostGreProperties {

    InputStream is = null;
    Properties pop = new Properties();


    @Value("${my.user}")
    private String stringValue;

    public DataBaseInfo getInfo(){
        is = PostGreProperties.class.getClassLoader().getResourceAsStream("datasource.properties");
        try {
            pop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DataBaseInfo dbi = new DataBaseInfo();
        dbi.setDirver(pop.getProperty("driver"));
        dbi.setUrl(pop.getProperty("url"));
        dbi.setUsername(pop.getProperty("username"));
        dbi.setPassword(pop.getProperty("password"));

        System.out.println("Driver is "+pop.getProperty("driver"));
        System.out.println("url is "+pop.getProperty("url"));
        System.out.println("username is "+pop.getProperty("username"));
        System.out.println("password is "+pop.getProperty("password"));
        System.out.println("String value is "+ stringValue);

        return dbi;
    }
}

