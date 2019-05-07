package com.example.catalog.config;

import com.example.catalog.pojo.DataBaseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
//@ConditionalOnClass()
public class PostGreConfig {

    @Autowired
    PostGreProperties pgp;


    @Bean
    public DataSource dataSource() {
        //System.out.println("***datasource");
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();

        DataBaseInfo dbi = pgp.getInfo();
        //String var = "jdbc:postgresql://localhost:5432/wangyitao";
        //DataBaseInfo db = (DataBaseInfo)ApplicationContextProvider.getBean(dataBaseInfo);
        //dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url(dbi.getUrl());
        dataSourceBuilder.username(dbi.getUsername());
        dataSourceBuilder.password(dbi.getPassword());
        return dataSourceBuilder.build();
    }

}
