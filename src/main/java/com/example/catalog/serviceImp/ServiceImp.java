package com.example.catalog.serviceImp;

import com.example.catalog.dao.DAO;
import com.example.catalog.exception.CatalogNotFoundException;
import com.example.catalog.exception.CreateCatalogException;
import com.example.catalog.exception.ErrorMessage;
import com.example.catalog.pojo.Catalog;
import com.example.catalog.pojo.CatalogDto;
import com.example.catalog.pojo.RequestCatalogDetail;
import com.example.catalog.service.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@org.springframework.stereotype.Service
public class ServiceImp implements Service {

    @Autowired
    DAO dao;

    @Override
    public CatalogDto getCatalog(int id) {

        Catalog c=dao.findCatalogById(id);
        if(c==null){
            throw new CatalogNotFoundException(ErrorMessage.RECORD_DOES_NOT_EXIST.getErrorMessage());
        }
        CatalogDto cd = new CatalogDto();
        BeanUtils.copyProperties(c,cd);
        return cd;

//        CatalogDto cd = new CatalogDto();
//        Catalog c = new Catalog();
//        c.setId(id);
//        c.setName("YitaoWang");
//        BeanUtils.copyProperties(c,cd);
//        return cd;
    }

    @Override
    public CatalogDto createCatalog(CatalogDto catalogdetail) {
        Catalog c = dao.findCatalogByName(catalogdetail.getName());
        if(c!=null){
            throw new RuntimeException(ErrorMessage.RECORD_ALREADY_EXISTS.getErrorMessage());
        }
        Catalog cl = new Catalog();
        BeanUtils.copyProperties(catalogdetail,cl);
        c=dao.save(cl);
        CatalogDto cdt = new CatalogDto();
        BeanUtils.copyProperties(c,cdt);
        return cdt;
    }
}
