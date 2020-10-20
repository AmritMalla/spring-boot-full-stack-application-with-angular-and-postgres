package com.amt.example.fullstackapp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Table(value = "users")
public  class User {

    @Id
    @Column
    private long id;

    @Column
    private String fullName;

    @Column
    private String username;

    @Column
    private boolean enabled;

    @Column
    private Date lastLogin;

    public User() {
    }

    public User(long id, String fullName, String username, boolean enabled, Date lastLogin) {
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

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}
