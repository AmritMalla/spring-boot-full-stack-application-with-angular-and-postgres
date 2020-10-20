package com.amt.example.fullstackapp.service;


import com.amt.example.fullstackapp.model.BookDTO;
import com.amt.example.fullstackapp.model.request.AddressRequestDTO;
import com.amt.example.fullstackapp.model.request.BookRequestDTO;

import java.util.Optional;

public interface BookService {

    Optional<BookDTO> getById(Long id);

    int save(BookRequestDTO dto);

    int update(BookDTO dto);

    int delete(Long id);

}
