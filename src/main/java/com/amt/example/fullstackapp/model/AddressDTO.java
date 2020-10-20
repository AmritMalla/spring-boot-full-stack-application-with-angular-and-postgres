package com.amt.example.fullstackapp.model;

import org.springframework.data.relational.core.mapping.Column;

/**
 * Created by Amrit Malla
 * date : 13/10/2020
 * time : 12:01 PM
 */
public class AddressDTO {

    private long userId;

    private String street;

    private String city;

    private String state;

    public AddressDTO() {
    }

    public AddressDTO(long userId, String street, String city, String state) {
        this.userId = userId;
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

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
}
