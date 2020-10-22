package com.amt.example.fullstackapp.dao.impl;

import com.amt.example.fullstackapp.dao.BookDAO;
import com.amt.example.fullstackapp.entity.Book;
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
public class BookDAOImpl implements BookDAO<Book>  {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean exists(Long id) {
        Boolean exist = jdbcTemplate.queryForObject("SELECT EXISTS (SELECT FROM books WHERE id = ?)",
                Boolean.class,
                id);
        if(exist != null)
            return exist;
        else return false;
    }

    @Override
    public int count() {
        Integer value = jdbcTemplate.queryForObject("SELECT count(*) FROM books",Integer.class);
        if (value != null) {
            return value;
        } else {
            return 0;
        }
    }

    @Override
    public int save(Book book) {
        return jdbcTemplate.update("INSERT INTO books(title, author, published_date) VALUES (?,?,?)",
                book.getTitle(),
                book.getAuthor(),
                book.getPublishedDate());
    }

    @Override
    public int update(Book book) {
        return jdbcTemplate.update("UPDATE books SET author = ?, title = ?, published_date = ? WHERE id = ?",
                book.getAuthor(),
                book.getTitle(),
                book.getPublishedDate(),
                book.getId());
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM books WHERE id = ?",
                id);
    }

    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT * FROM books",
                (rs,rowNum)-> new Book(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDate("published_date").toLocalDate()
                ));
    }

    @Override
    public Book findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM books WHERE id = ?",
                new Object[]{id},
                (rs, rowNum) -> new Book(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDate("published_date").toLocalDate()
                ));
    }

    @Override
    public List<Book> findByBookName(String bookName) {
        return null;
    }
}
