package com.amt.example.fullstackapp.service;


import com.amt.example.fullstackapp.model.AddressDTO;
import com.amt.example.fullstackapp.model.request.AddressRequestDTO;

import java.util.Optional;

public interface AddressService {

    Optional<AddressDTO> getById(Long id);

    int save(AddressRequestDTO dto);

    int update(AddressRequestDTO dto);

    int delete(Long id);

    boolean userIdAlreadyExist(Long id);

}
