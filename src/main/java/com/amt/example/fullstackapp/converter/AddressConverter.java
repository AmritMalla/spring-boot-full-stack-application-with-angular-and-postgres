package com.amt.example.fullstackapp.converter;

import com.amt.example.fullstackapp.entity.Address;
import com.amt.example.fullstackapp.model.AddressDTO;
import com.amt.example.fullstackapp.model.request.AddressRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter{

    public AddressDTO entityToDto(Address address) {
        AddressDTO dto = new AddressDTO();
        dto.setUserId(address.getUserId());
        dto.setStreet(address.getStreet());
        dto.setCity(address.getCity());
        dto.setState(address.getState());
        return dto;
    }

    public Address requestDTOtoEntity(AddressRequestDTO dto) {
        Address address = new Address();
        address.setUserId(dto.getUserId());
        address.setCity(dto.getCity());
        address.setStreet(dto.getStreet());
        address.setState(dto.getState());
        return address;
    }
}
