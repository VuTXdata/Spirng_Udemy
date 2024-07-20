package com.vuhocspringboot.demo.rest;

import com.vuhocspringboot.demo.entity.Student;

public class StudentErrolResponse {
    private int status;
    private String message;
    private long timeStamp;

    public StudentErrolResponse() {
    }

    public StudentErrolResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
