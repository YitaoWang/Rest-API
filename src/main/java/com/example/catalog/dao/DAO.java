package com.example.catalog.dao;


import com.example.catalog.pojo.Catalog;
import com.example.catalog.pojo.CatalogDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DAO extends JpaRepository<Catalog, Integer> {

    Catalog findCatalogById(int id);

    Catalog findCatalogByName(String name);

    //Catalog createCatalog(CatalogDto cdt);
}
