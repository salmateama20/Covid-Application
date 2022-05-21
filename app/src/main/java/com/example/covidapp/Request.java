package com.example.covidapp;

public class Request {
    String patient;
    boolean closed;
    String request;

    public Request(String patient ,String request,  boolean closed) {
        this.patient = patient;
        this.closed=closed;
        this.request=request;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
