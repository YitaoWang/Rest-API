package com.example.catalog.exception;

public class CatalogNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -6560935729306156014L;

    public CatalogNotFoundException(String message) {
        super(message);

    }
}
