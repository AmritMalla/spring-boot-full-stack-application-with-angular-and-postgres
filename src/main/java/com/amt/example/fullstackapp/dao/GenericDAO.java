package com.amt.example.fullstackapp.dao;

import java.util.List;

/**
 * Created by Amrit Malla
 * date : 13/10/2020
 * time : 6:26 AM
 */
public interface GenericDAO<T> {
    boolean exists(Long id);
    int count();
    int save(T t);
    int update(T t);
    int deleteById(Long id);
    List<T> findAll();
    T findById(Long id);

}
