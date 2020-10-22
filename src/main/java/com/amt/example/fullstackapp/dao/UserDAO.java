package com.amt.example.fullstackapp.dao;

import com.amt.example.fullstackapp.entity.User;

import java.util.Optional;

public interface UserDAO<T> extends GenericDAO<User> {

    Optional<User> getByUsername(String username);

    Boolean existByUsername(String username);

}
