package com.amt.example.fullstackapp.dao.impl;

import com.amt.example.fullstackapp.dao.ReviewDAO;
import com.amt.example.fullstackapp.entity.Review;
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
public class ReviewDAOImpl implements ReviewDAO<Review>  {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ReviewDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean exists(Long id) {
        Boolean exist = jdbcTemplate.queryForObject("SELECT EXISTS (SELECT FROM reviews WHERE id = ?)",
                Boolean.class,
                id);
        if(exist != null)
            return exist;
        else return false;
    }

    @Override
    public int count() {
        Integer value = jdbcTemplate.queryForObject("SELECT count(*) FROM reviews",Integer.class);
        if (value != null) {
            return value;
        } else {
            return 0;
        }
    }

    @Override
    public int save(Review review) {
        return jdbcTemplate.update("INSERT INTO reviews(book_id, reviewer_name, content, rating) VALUES (?,?,?,?)",
                review.getBookId(),
                review.getReviewerName(),
                review.getContent(),
                review.getRating());
    }

    @Override
    public int update(Review review) {
        int update = jdbcTemplate.update("UPDATE reviews SET book_id= ?, content = ?,rating = ?, published_date = ? WHERE id = ?",
                review.getBookId(),
                review.getContent(),
                review.getRating(),
                review.getPublishedDate(),
                review.getId());
        return update;
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM reviews WHERE id = ?",
                id);
    }

    @Override
    public List<Review> findAll() {
        return jdbcTemplate.query("SELECT * FROM reviews",
                (rs,rowNum)-> new Review(
                        rs.getLong("id"),
                        rs.getLong("book_id"),
                        rs.getString("reviewer_name"),
                        rs.getString("content"),
                        rs.getInt("rating"),
                        rs.getTimestamp("published_date")
                ));
    }

    @Override
    public Review findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM reviews WHERE id = ?",
                new Object[]{id},
                (rs, rowNum) -> new Review(
                        rs.getLong("id"),
                        rs.getLong("book_id"),
                        rs.getString("reviewer_name"),
                        rs.getString("content"),
                        rs.getInt("rating"),
                        rs.getTimestamp("published_date")
                ));
    }

}
