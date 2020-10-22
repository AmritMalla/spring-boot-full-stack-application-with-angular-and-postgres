package com.amt.example.fullstackapp.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRequestDTO {

    private Long id;

    @JsonProperty(required = true)
    @NotBlank(message = "Full name can't be blank")
    @Size(min = 5, max = 100, message = "Full name length should be greater than 4 and less than or equals to 100")
    private String fullName;

    @JsonProperty(required = true)
    @NotBlank(message = "Username can't be blanck")
    @Size(min = 3, max = 100, message = "Length must be 3 to 100")
    private String username;

    public UserRequestDTO() {
    }

    public UserRequestDTO(@NotBlank(message = "Full name can't be blank") @Size(min = 5, max = 100, message = "Full name length should be greater than 4 and less than or equals to 100") String fullName) {
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
