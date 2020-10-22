package com.amt.example.fullstackapp.service.impl;

import com.amt.example.fullstackapp.converter.UserConverter;
import com.amt.example.fullstackapp.dao.UserDAO;
import com.amt.example.fullstackapp.entity.User;
import com.amt.example.fullstackapp.model.UserDTO;
import com.amt.example.fullstackapp.model.request.UserRequestDTO;
import com.amt.example.fullstackapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private UserDAO<User> userDAO;

    private UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserDAO<User> userDAO, UserConverter userConverter) {
        this.userDAO = userDAO;
        this.userConverter = userConverter;
    }

    @Override
    public Optional<UserDTO> getById(Long id) {
        if (userDAO.exists(id)) {
            UserDTO dto = userConverter.entityToDto(userDAO.findById(id));
            return Optional.of(dto);
        }
        return Optional.empty();
    }

    @Override
    public int save(UserRequestDTO dto) {
        return userDAO.save(userConverter.requestDTOtoEntity(dto));
    }

    @Override
    public int update(UserRequestDTO dto) {
        return userDAO.update(userConverter.requestDTOtoEntity(dto));
    }

    @Override
    public int delete(Long id) {
        if (userDAO.exists(id)) {
            return userDAO.deleteById(id);
        }
        return 0;
    }

    @Override
    public boolean existById(Long id) {
        return userDAO.exists(id);
    }

    @Override
    public Optional<UserDTO> getByUsername(String username) {
        Optional<User> optional = userDAO.getByUsername(username);
        UserDTO dto = null;
        if (optional.isPresent()) {
            dto = userConverter.entityToDto(optional.get());
        }
        return Optional.ofNullable(dto);
    }

    @Override
    public boolean existByUsername(String username) {
        return userDAO.existByUsername(username);
    }
}
