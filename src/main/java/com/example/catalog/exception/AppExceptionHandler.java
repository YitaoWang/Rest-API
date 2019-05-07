package com.example.catalog.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.catalog.pojo.ErrorMessage;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value= {CatalogNotFoundException.class})
    public ResponseEntity<Object> handleUserServiceException(CatalogNotFoundException cex, WebRequest request) throws URISyntaxException {

//        URI location = new URI("http://www.w3.org/pub/WWW/People.html");
//        String location = "www.google.com";
//        HttpHeaders responseHeader = new HttpHeaders();
//        responseHeader.setLocation(location);
//        UriComponentsBuilder builder =UriComponentsBuilder.newInstance();
//        UriComponents components = builder.path(location).build();
        ErrorMessage em = new ErrorMessage(new Date(), cex.getMessage());
        return new ResponseEntity<>(em, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value= {CreateCatalogException.class})
    public ResponseEntity<Object> otherException(Exception ex, WebRequest request){

        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR );
    }
}
