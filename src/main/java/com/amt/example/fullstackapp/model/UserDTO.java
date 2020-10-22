package com.amt.example.fullstackapp.model;

import java.time.LocalDateTime;

/**
 * Created by Amrit Malla
 * date : 13/10/2020
 * time : 12:01 PM
 */
public class UserDTO {

    private long id;

    private String fullName;

    private String username;

    private boolean enabled;

    private LocalDateTime lastLogin;

    public UserDTO() {
    }

    public UserDTO(long id, String fullName, String username, boolean enabled, LocalDateTime lastLogin) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.enabled = enabled;
        this.lastLogin = lastLogin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
}
