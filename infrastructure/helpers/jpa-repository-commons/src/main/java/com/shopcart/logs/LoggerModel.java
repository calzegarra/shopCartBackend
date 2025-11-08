package com.shopcart.logs;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

public class LoggerModel {
    public String id;
    public String name;
    public String timestamp;
    public String application;
    public String service;
    public String message;
    public String stacktrace;

    public LoggerModel(String message, String application, String service, String name) {
        this.id = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now().toString();
        this.message = message;
        this.application = application;
        this.service = service;
        this.name = name;
    }

    public LoggerModel(String application, String service, String name, Exception ex) {
        this.id = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now().toString();
        this.message = ex.getMessage();
        this.application = application;
        this.service = service;
        this.stacktrace = Arrays.toString(ex.getStackTrace());
        this.name = name;
    }
}
