package com.example.catalog.service;

import com.example.catalog.pojo.CatalogDto;
import com.example.catalog.pojo.RequestCatalogDetail;

public interface Service {

    CatalogDto getCatalog(int id);

    CatalogDto createCatalog(CatalogDto catalogdetail);

}
