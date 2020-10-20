package com.amt.example.fullstackapp.dao;

import com.amt.example.fullstackapp.entity.Book;

import java.util.List;

public interface BookDAO<T> extends GenericDAO<Book> {
    List<Book>  findByBookName(String bookName);

    //Book findById(Long id);
}
