package com.amt.example.fullstackapp.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;

public class AddressRequestDTO {

    @JsonProperty(required = true)
    @NotNull(message = "User Id can't be blank")
    private long userId;

    @JsonProperty(required = true)
    @NotBlank
    @Size(min = 3, max = 200,message = "Street length must be greater than two and less than 200")
    private String street;

    @JsonProperty(required = true)
    @NotBlank
    @Size(min = 2, max = 100,message = "City name length must be in between two and hundred")
    private String city;

    @JsonProperty(required = true)
    @NotBlank
    @Size(min = 2, max = 100,message = "State name length must be in between two and hundred")
    private String state;

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
