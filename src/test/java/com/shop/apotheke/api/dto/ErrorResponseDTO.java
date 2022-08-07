package com.shop.apotheke.api.dto;

public class ErrorResponseDTO {
    private Integer statusCode;
    private String error;
    private String message;

    public Integer getStatusCode() {
        return statusCode;
    }

    public ErrorResponseDTO setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getError() {
        return error;
    }

    public ErrorResponseDTO setError(String error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ErrorResponseDTO setMessage(String message) {
        this.message = message;
        return this;
    }
}
