package com.example.catalog.pojo;

import java.io.Serializable;

public class CatalogDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
