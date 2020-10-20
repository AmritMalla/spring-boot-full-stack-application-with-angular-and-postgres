package com.amt.example.fullstackapp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table(value = "addresses")
public class Address {
    @Id
    @Column
    private long userId;

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private String state;

    public Address() {
    }

    public Address(long userId, String street, String city, String state) {
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
