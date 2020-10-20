package com.amt.example.fullstackapp.converter;

import com.amt.example.fullstackapp.entity.Book;
import com.amt.example.fullstackapp.model.BookDTO;
import com.amt.example.fullstackapp.model.BookDTO;
import com.amt.example.fullstackapp.model.request.BookRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {

    public BookDTO entityToDto(Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setAuthor(book.getAuthor());
        dto.setTitle(book.getTitle());
        dto.setPublishedDate(book.getPublishedDate());
        return dto;
    }

    public Book requestDTOtoEntity(BookRequestDTO dto) {
        Book book = new Book();
        book.setAuthor(dto.getAuthor());
        book.setTitle(dto.getTitle());
        book.setPublishedDate(dto.getPublishedDate());
        return book;
    }

    public Book dtoToEntity(BookDTO dto){
        Book book = new Book();
        book.setId(dto.getId());
        book.setAuthor(dto.getAuthor());
        book.setTitle(dto.getTitle());
        book.setPublishedDate(dto.getPublishedDate());
        return book;
    }
}
