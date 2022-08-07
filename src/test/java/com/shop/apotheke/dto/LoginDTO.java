package com.shop.apotheke.dto;

public class LoginDTO {
    private String customerNumber;
    private String password;

    public String getCustomerNumber() {
        return customerNumber;
    }

    public LoginDTO setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
