package com.amt.example.fullstackapp.dao.impl;

import com.amt.example.fullstackapp.dao.CheckoutDAO;
import com.amt.example.fullstackapp.entity.Checkout;
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
public class CheckoutDAOImpl implements CheckoutDAO<Checkout>  {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CheckoutDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean exists(Long id) {
        Boolean exist = jdbcTemplate.queryForObject("SELECT EXISTS (SELECT FROM checkouts WHERE id = ?)",
                Boolean.class,
                id);
        if(exist != null)
            return exist;
        else return false;
    }

    @Override
    public int count() {
        Integer value = jdbcTemplate.queryForObject("SELECT count(*) FROM checkouts",Integer.class);
        if (value != null) {
            return value;
        } else {
            return 0;
        }
    }

    @Override
    public int save(Checkout checkout) {
        return jdbcTemplate.update("INSERT INTO checkouts(user_id, book_id) VALUES (?,?)",
                checkout.getUserId(),
                checkout.getBookId());
    }

    @Override
    public int update(Checkout checkout) {
        return jdbcTemplate.update("UPDATE checkouts SET user_id = ?, book_id = ?, return_date = ? WHERE id = ?",
                checkout.getUserId(),
                checkout.getBookId(),
                checkout.getReturnDate(),
                checkout.getId());
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM checkouts WHERE id = ?",
                id);
    }

    @Override
    public List<Checkout> findAll() {
        return jdbcTemplate.query("SELECT * FROM checkouts",
                (rs,rowNum)-> new Checkout(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getLong("book_id"),
                        rs.getTimestamp("checkout_date").toLocalDateTime().toLocalDate(),
                        (rs.getTimestamp("return_date")==null)?
                                null:rs.getTimestamp("return_date").toLocalDateTime().toLocalDate()
                ));
    }

    @Override
    public Checkout findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM checkouts WHERE id = ?",
                new Object[]{id},
                (rs, rowNum) -> new Checkout(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getLong("book_id"),
                        rs.getDate("checkout_date").toLocalDate(),
                        (rs.getTimestamp("return_date")==null)?
                                null:rs.getTimestamp("return_date").toLocalDateTime().toLocalDate()
                ));
    }

}
