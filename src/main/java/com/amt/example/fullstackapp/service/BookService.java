package com.amt.example.fullstackapp.service;


import com.amt.example.fullstackapp.model.BookDTO;
import com.amt.example.fullstackapp.model.request.AddressRequestDTO;
import com.amt.example.fullstackapp.model.request.BookRequestDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<BookDTO> getById(Long id);

    List<BookDTO> getAll();

    int save(BookRequestDTO dto);

    int update(BookRequestDTO dto);

    int delete(Long id);

    boolean existById(Long id);

}
