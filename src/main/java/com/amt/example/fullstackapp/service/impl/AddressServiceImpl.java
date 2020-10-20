package com.amt.example.fullstackapp.service.impl;

import com.amt.example.fullstackapp.converter.AddressConverter;
import com.amt.example.fullstackapp.entity.Address;
import com.amt.example.fullstackapp.model.AddressDTO;
import com.amt.example.fullstackapp.model.request.AddressRequestDTO;
import com.amt.example.fullstackapp.dao.AddressDAO;
import com.amt.example.fullstackapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {


    private AddressDAO<Address> addressDAO;

    private AddressConverter addressConverter;

    @Autowired
    public AddressServiceImpl(AddressDAO<Address> addressDAO, AddressConverter addressConverter) {
        this.addressDAO = addressDAO;
        this.addressConverter = addressConverter;
    }

    @Override
    public Optional<AddressDTO> getById(Long id) {
        if(addressDAO.exists(id)){
            AddressDTO dto = addressConverter.entityToDto(addressDAO.findById(id));
            return Optional.of(dto);
        }
        return Optional.empty();
    }

    @Override
    public int save(AddressRequestDTO dto) {
        return addressDAO.save(addressConverter.requestDTOtoEntity(dto));
    }

    @Override
    public int update(AddressRequestDTO dto) {
        return addressDAO.update(addressConverter.requestDTOtoEntity(dto));
    }

    @Override
    public int delete(Long id) {
        if(addressDAO.exists(id)){
            return addressDAO.deleteById(id);
        }
        return 0;
    }

    @Override
    public boolean userIdAlreadyExist(Long id) {
        return addressDAO.exists(id);
    }
}
