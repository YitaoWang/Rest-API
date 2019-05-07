package com.example.catalog.exception;

public enum ErrorMessage {

    MISSING_REQUIRED_FIELD("Missing required filed. Please check documentation for required fields"),
    RECORD_ALREADY_EXISTS("Record already exists"),
    RECORD_DOES_NOT_EXIST("Record does not exits");

    String errorMessage;

    private ErrorMessage(String s){
        this.errorMessage=s;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
