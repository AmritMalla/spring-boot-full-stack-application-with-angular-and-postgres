package com.amt.example.fullstackapp.service.impl;

import com.amt.example.fullstackapp.converter.ReviewConverter;
import com.amt.example.fullstackapp.dao.ReviewDAO;
import com.amt.example.fullstackapp.entity.Review;
import com.amt.example.fullstackapp.model.ReviewDTO;
import com.amt.example.fullstackapp.model.request.ReviewRequestDTO;
import com.amt.example.fullstackapp.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {


    private ReviewDAO<Review> reviewDAO;

    private ReviewConverter reviewConverter;

    @Autowired
    public ReviewServiceImpl(ReviewDAO<Review> reviewDAO, ReviewConverter reviewConverter) {
        this.reviewDAO = reviewDAO;
        this.reviewConverter = reviewConverter;
    }

    @Override
    public Optional<ReviewDTO> getById(Long id) {
        if(reviewDAO.exists(id)){
            ReviewDTO dto = reviewConverter.entityToDto(reviewDAO.findById(id));
            return Optional.of(dto);
        }
        return Optional.empty();
    }

    @Override
    public int save(ReviewRequestDTO dto) {
        return reviewDAO.save(reviewConverter.requestDTOtoEntity(dto));
    }

    @Override
    public int update(ReviewDTO dto) {
        return reviewDAO.update(reviewConverter.dtoToEntity(dto));
    }

    @Override
    public int delete(Long id) {
        if(reviewDAO.exists(id)){
            return reviewDAO.deleteById(id);
        }
        return 0;
    }
}
