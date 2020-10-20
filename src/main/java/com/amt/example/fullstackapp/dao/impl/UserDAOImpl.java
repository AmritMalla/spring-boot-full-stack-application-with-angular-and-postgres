package com.amt.example.fullstackapp.dao.impl;

import com.amt.example.fullstackapp.dao.BookDAO;
import com.amt.example.fullstackapp.dao.UserDAO;
import com.amt.example.fullstackapp.entity.User;
import com.amt.example.fullstackapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Amrit Malla
 * date : 13/10/2020
 * time : 6:25 AM
 */
@Repository
public class UserDAOImpl implements UserDAO<User> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean exists(Long id) {
        Boolean exist = jdbcTemplate.queryForObject("SELECT EXISTS (SELECT FROM users WHERE id = ?)",
                Boolean.class,
                id);
        if(exist != null)
            return exist;
        else return false;
    }

    @Override
    public int count() {
        Integer value = jdbcTemplate.queryForObject("SELECT count(*) FROM users",Integer.class);
        if (value != null) {
            return value;
        } else {
            return 0;
        }
    }

    @Override
    public int save(User user) {
        return jdbcTemplate.update("INSERT INTO users(full_name, username) VALUES (?,?)",
                user.getFullName(),
                user.getUsername());
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update("UPDATE users SET full_name = ?, username = ?, last_login = ?, enabled= ? WHERE id = ?",
                user.getFullName(),
                user.getUsername(),
                user.getLastLogin(),
                user.isEnabled(),
                user.getId());
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM users WHERE id = ?",
                id);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users",
                (rs,rowNum)-> new User(
                        rs.getLong("id"),
                        rs.getString("full_name"),
                        rs.getString("username"),
                        rs.getBoolean("enabled"),
                        rs.getTimestamp("last_login")
                ));
    }

    @Override
    public User findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?",
                new Object[]{id},
                (rs, rowNum) -> new User(
                        rs.getLong("id"),
                        rs.getString("full_name"),
                        rs.getString("username"),
                        rs.getBoolean("enabled"),
                        rs.getTimestamp("last_login")
                ));
    }

}
