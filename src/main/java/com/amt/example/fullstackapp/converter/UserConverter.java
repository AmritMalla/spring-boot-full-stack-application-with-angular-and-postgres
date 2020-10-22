package com.amt.example.fullstackapp.converter;

import com.amt.example.fullstackapp.entity.User;
import com.amt.example.fullstackapp.model.UserDTO;
import com.amt.example.fullstackapp.model.request.UserRequestDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class UserConverter {

    public UserDTO entityToDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFullName(user.getFullName());
        dto.setLastLogin(user.getLastLogin());
        dto.setUsername(user.getUsername());
        dto.setEnabled(user.isEnabled());
        return dto;
    }

    public User requestDTOtoEntity(UserRequestDTO dto) {
        User user = new User();
        user.setFullName(dto.getFullName());
        user.setUsername(dto.getUsername());
        return user;
    }

    public User dtoToEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setFullName(dto.getFullName());
        user.setEnabled(dto.isEnabled());
        user.setUsername(dto.getUsername());
        user.setLastLogin(dto.getLastLogin()==null? LocalDateTime.now() :dto.getLastLogin());
        return user;
    }
}
