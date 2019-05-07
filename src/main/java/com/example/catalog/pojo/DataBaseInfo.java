package com.example.catalog.pojo;

import org.springframework.context.annotation.Bean;


public class DataBaseInfo {

    private String dirver;
    private String url;
    private String username;
    private String password;

    public String getDirver() {
        return dirver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setDirver(String dirver) {
        this.dirver = dirver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
