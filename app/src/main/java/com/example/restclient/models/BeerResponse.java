package com.example.restclient.models;

public class BeerResponse {

    private boolean error;
    private String message;
    private Beer beer;

    public BeerResponse(boolean error, String message, Beer beer) {
        this.error = error;
        this.message = message;
        this.beer = beer;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }
}
