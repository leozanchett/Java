package com.hibernate.hpower.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
    @Column(name = "EMP_STREET")
    private String street;
    @Column(name = "EMP_CITY")
    private String city;
    @Column(name = "EMP_STATE")
    private String state;
    @Column(name = "EMP_PIN")
    private int pin;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
