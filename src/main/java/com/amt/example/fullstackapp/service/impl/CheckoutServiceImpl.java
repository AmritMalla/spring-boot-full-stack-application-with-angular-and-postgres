package com.amt.example.fullstackapp.service.impl;

import com.amt.example.fullstackapp.converter.CheckoutConverter;
import com.amt.example.fullstackapp.dao.CheckoutDAO;
import com.amt.example.fullstackapp.entity.Checkout;
import com.amt.example.fullstackapp.model.CheckoutDTO;
import com.amt.example.fullstackapp.model.request.CheckoutRequestDTO;
import com.amt.example.fullstackapp.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CheckoutServiceImpl implements CheckoutService {


    private CheckoutDAO<Checkout> checkoutDAO;

    private CheckoutConverter checkoutConverter;

    @Autowired
    public CheckoutServiceImpl(CheckoutDAO<Checkout> checkoutDAO, CheckoutConverter checkoutConverter) {
        this.checkoutDAO = checkoutDAO;
        this.checkoutConverter = checkoutConverter;
    }

    @Override
    public Optional<CheckoutDTO> getById(Long id) {
        if (checkoutDAO.exists(id)) {
            CheckoutDTO dto = checkoutConverter.entityToDto(checkoutDAO.findById(id));
            return Optional.of(dto);
        }
        return Optional.empty();
    }

    @Override
    public List<CheckoutDTO> getAll() {
        return checkoutDAO.findAll().stream().map(s -> checkoutConverter.entityToDto(s)).collect(Collectors.toList());
    }

    @Override
    public int save(CheckoutRequestDTO dto) {
        return checkoutDAO.save(checkoutConverter.requestDTOtoEntity(dto));
    }

    @Override
    public int update(CheckoutRequestDTO dto) {
        return checkoutDAO.update(checkoutConverter.requestDTOtoEntity(dto));
    }

    @Override
    public int delete(Long id) {
        return checkoutDAO.deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return checkoutDAO.exists(id);
    }
}
