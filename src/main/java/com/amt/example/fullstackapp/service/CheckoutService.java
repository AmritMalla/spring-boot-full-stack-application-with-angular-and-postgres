package com.amt.example.fullstackapp.service;


import com.amt.example.fullstackapp.model.CheckoutDTO;
import com.amt.example.fullstackapp.model.request.AddressRequestDTO;
import com.amt.example.fullstackapp.model.request.CheckoutRequestDTO;

import java.util.Optional;

public interface CheckoutService {

    Optional<CheckoutDTO> getById(Long id);

    int save(CheckoutRequestDTO dto);

    int update(CheckoutRequestDTO dto);

    int delete(Long id);

    boolean existById(Long id);

}
