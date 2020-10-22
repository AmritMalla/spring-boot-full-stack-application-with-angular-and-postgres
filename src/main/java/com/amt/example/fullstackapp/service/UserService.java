package com.amt.example.fullstackapp.service;


import com.amt.example.fullstackapp.model.UserDTO;
import com.amt.example.fullstackapp.model.request.AddressRequestDTO;
import com.amt.example.fullstackapp.model.request.UserRequestDTO;

import java.util.Optional;

public interface UserService {

    Optional<UserDTO> getById(Long id);

    int save(UserRequestDTO dto);

    int update(UserRequestDTO dto);

    int delete(Long id);

    boolean existById(Long id);

    Optional<UserDTO> getByUsername(String username);

    boolean existByUsername(String username);

}
