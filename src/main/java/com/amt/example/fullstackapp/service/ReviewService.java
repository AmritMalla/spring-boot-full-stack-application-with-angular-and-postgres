package com.amt.example.fullstackapp.service;


import com.amt.example.fullstackapp.model.ReviewDTO;
import com.amt.example.fullstackapp.model.request.AddressRequestDTO;
import com.amt.example.fullstackapp.model.request.ReviewRequestDTO;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    Optional<ReviewDTO> getById(Long id);

    List<ReviewDTO> getAll();

    int save(ReviewRequestDTO dto);

    int update(ReviewRequestDTO dto);

    int delete(Long id);

    boolean existById(Long id);

}
