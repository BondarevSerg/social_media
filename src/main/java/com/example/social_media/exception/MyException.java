package com.example.social_media.exception;

import lombok.Data;

import java.util.Date;
@Data
public class MyException {

    private int status;
    private String message;
    private Date timestamp;

    public MyException(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}
