package com.amt.example.fullstackapp.service.impl;

import com.amt.example.fullstackapp.converter.BookConverter;
import com.amt.example.fullstackapp.dao.BookDAO;
import com.amt.example.fullstackapp.entity.Book;
import com.amt.example.fullstackapp.model.BookDTO;
import com.amt.example.fullstackapp.model.request.BookRequestDTO;
import com.amt.example.fullstackapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {


    private BookDAO<Book> bookDAO;

    private BookConverter bookConverter;

    @Autowired
    public BookServiceImpl(BookDAO<Book> bookDAO, BookConverter bookConverter) {
        this.bookDAO = bookDAO;
        this.bookConverter = bookConverter;
    }

    @Override
    public Optional<BookDTO> getById(Long id) {
        if (bookDAO.exists(id)) {
            BookDTO dto = bookConverter.entityToDto(bookDAO.findById(id));
            return Optional.of(dto);
        }
        return Optional.empty();
    }

    @Override
    public List<BookDTO> getAll() {
        return bookDAO.findAll().stream().map(s -> bookConverter.entityToDto(s)).collect(Collectors.toList());
    }

    @Override
    public int save(BookRequestDTO dto) {
        return bookDAO.save(bookConverter.requestDTOtoEntity(dto));
    }

    @Override
    public int update(BookRequestDTO dto) {
        return bookDAO.update(bookConverter.requestDTOtoEntity(dto));
    }

    @Override
    public int delete(Long id) {
        if (bookDAO.exists(id)) {
            return bookDAO.deleteById(id);
        }
        return 0;
    }

    @Override
    public boolean existById(Long id) {
        return bookDAO.exists(id);
    }
}
