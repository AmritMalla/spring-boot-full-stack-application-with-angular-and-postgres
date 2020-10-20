package com.amt.example.fullstackapp.dao;

import com.amt.example.fullstackapp.entity.Address;

import java.util.List;

public interface AddressDAO<T> extends GenericDAO<Address> {

    List<Address> findAllByCity(String city);

    List<Address> findAllByState(String state);

   // Address findById(Long id);

}
