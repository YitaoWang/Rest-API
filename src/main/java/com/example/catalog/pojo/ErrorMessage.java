package com.example.catalog.pojo;

import java.util.Date;

public class ErrorMessage {

    private Date timestamp;

    private String Message;

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return Message;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public ErrorMessage(Date timestamp, String message) {
        this.timestamp = timestamp;
        Message = message;
    }
}
