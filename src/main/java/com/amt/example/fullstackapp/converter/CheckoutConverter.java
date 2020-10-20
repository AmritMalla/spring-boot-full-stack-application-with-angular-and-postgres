package com.amt.example.fullstackapp.converter;

import com.amt.example.fullstackapp.entity.Checkout;
import com.amt.example.fullstackapp.model.CheckoutDTO;
import com.amt.example.fullstackapp.model.request.CheckoutRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class CheckoutConverter {

    public CheckoutDTO entityToDto(Checkout checkout) {
        CheckoutDTO dto = new CheckoutDTO();
        dto.setId(checkout.getId());
        dto.setUserId(checkout.getUserId());
        dto.setBookId(checkout.getBookId());
        dto.setCheckoutDate(checkout.getCheckoutDate());
        dto.setReturnDate(checkout.getReturnDate());
        return dto;
    }

    public Checkout requestDTOtoEntity(CheckoutRequestDTO dto) {
        Checkout checkout = new Checkout();
        checkout.setUserId(dto.getUserId());
        checkout.setBookId(dto.getBookId());
        checkout.setCheckoutDate(dto.getCheckoutDate());
        return checkout;
    }

    public Checkout dtoToEntity(CheckoutDTO dto) {
        Checkout checkout = new Checkout();
        checkout.setId(dto.getId());
        checkout.setUserId(dto.getUserId());
        checkout.setBookId(dto.getBookId());
        checkout.setCheckoutDate(dto.getCheckoutDate());
        checkout.setReturnDate(dto.getReturnDate());
        return checkout;
    }
}
