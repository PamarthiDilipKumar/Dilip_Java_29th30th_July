package com.example.demo.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Service;

@Embeddable

public class EmployeeAddress {

    private String state;
    private String street;
    private String pin;
    private String City;


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
}
