package com.example.catalog.controller;


import com.example.catalog.exception.CreateCatalogException;
import com.example.catalog.exception.ErrorMessage;
import com.example.catalog.pojo.CatalogDto;
import com.example.catalog.pojo.CatalogResponse;
import com.example.catalog.pojo.RequestCatalogDetail;
import com.example.catalog.service.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("catalog") //http://localhost:8080/catalog
public class Controller {

    @Autowired
    Service s;

    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody CatalogResponse getCatalog(@PathVariable int id){
        System.out.println("get method");
        CatalogResponse cr = new CatalogResponse();
        CatalogDto cdt = s.getCatalog(id);
        BeanUtils.copyProperties(cdt, cr);
        return cr;
    }


    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
                    produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CatalogResponse> createCatalog(@RequestBody RequestCatalogDetail catalogDetail) {

        //System.out.println("create method");
        if(catalogDetail.getName()==null||catalogDetail.getName().isEmpty()){
            throw new CreateCatalogException(ErrorMessage.MISSING_REQUIRED_FIELD.getErrorMessage());
        }
        CatalogResponse cr = new CatalogResponse();
        CatalogDto cdt = new CatalogDto();
        BeanUtils.copyProperties(catalogDetail, cdt);
        CatalogDto cdt2 = s.createCatalog(cdt);

//        int id = cdt2.getId();
//        response.setHeader("location","www.google.com");
//        response.setStatus(302);
//        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
//        UriComponents uriComponents = builder.path("http://localhost:8080/catalog/{id}").buildAndExpand(id);

        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(uriComponents.toUri());
//        System.out.println(uriComponents.toUri().toString());
        //HttpServletResponse response;
        //response.sendRedirect(uriComponents.toUri().toString());
        //return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

        BeanUtils.copyProperties(cdt2, cr);
        return new ResponseEntity(cr, headers, HttpStatus.CREATED);
        //return null;
    }

   @GetMapping(path="/redirect")
    public void method(HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Location", "http://www.google.com");
        httpServletResponse.setStatus(302);
       //return new ModelAndView("redirect:" + "http://www.google.com");
    }

}
