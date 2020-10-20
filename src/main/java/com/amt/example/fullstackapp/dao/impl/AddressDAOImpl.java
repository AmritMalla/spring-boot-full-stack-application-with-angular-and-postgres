package com.amt.example.fullstackapp.dao.impl;

import com.amt.example.fullstackapp.entity.Address;
import com.amt.example.fullstackapp.dao.AddressDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDAOImpl implements AddressDAO<Address> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AddressDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean exists(Long id) {
        Boolean exist = jdbcTemplate.queryForObject("SELECT EXISTS (SELECT FROM addresses WHERE user_id = ?)",
                Boolean.class,
                id);
        if(exist != null){
            return exist;
        }else {
            return false;
        }
    }

    @Override
    public int count() {
        Integer value = jdbcTemplate.queryForObject("SELECT count(*) FROM addresses",Integer.class);
        if (value != null) {
            return value;
        } else {
            return 0;
        }
    }

    @Override
    public int save(Address address) {
        return jdbcTemplate.update("INSERT INTO addresses(user_id,street,city,state) VALUES (?,?,?,?)",
                address.getUserId(),
                address.getStreet(),
                address.getCity(),
                address.getState());
    }

    @Override
    public int update(Address address) {
        return jdbcTemplate.update("UPDATE addresses SET street = ?, city = ?, state = ? WHERE user_id = ?",
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getUserId());
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM addresses WHERE user_id = ?",
                id);
    }

    @Override
    public List<Address> findAll() {
        return jdbcTemplate.query("SELECT * FROM addresses",
                (rs,rowNum)-> new Address(
                        rs.getLong("user_id"),
                        rs.getString("street"),
                        rs.getString("city"),
                        rs.getString("state")
                ));
    }

    @Override
    public List<Address> findAllByCity(String city) {
        return jdbcTemplate.query("SELECT * FROM addresses WHERE city = ?",
                new Object[]{city},
                (rs,rowNum)-> new Address(
                        rs.getLong("user_id"),
                        rs.getString("street"),
                        rs.getString("city"),
                        rs.getString("state")
                ));
    }

    @Override
    public List<Address> findAllByState(String state) {
        return jdbcTemplate.query("SELECT * FROM addresses WHERE state = ?",
                new Object[]{state},
                (rs,rowNum)-> new Address(
                        rs.getLong("user_id"),
                        rs.getString("street"),
                        rs.getString("city"),
                        rs.getString("state")
                ));
    }

    @Override
    public Address findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM addresses WHERE user_id = ?",
                new Object[]{id},
                (rs, rowNum) -> new Address(
                        rs.getLong("user_id"),
                        rs.getString("street"),
                        rs.getString("city"),
                        rs.getString("state")
                ));
    }
}
