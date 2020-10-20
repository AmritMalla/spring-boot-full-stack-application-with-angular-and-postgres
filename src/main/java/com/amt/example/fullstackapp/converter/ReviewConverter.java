package com.amt.example.fullstackapp.converter;

import com.amt.example.fullstackapp.entity.Review;
import com.amt.example.fullstackapp.model.ReviewDTO;
import com.amt.example.fullstackapp.model.ReviewDTO;
import com.amt.example.fullstackapp.model.request.ReviewRequestDTO;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ReviewConverter {

    public ReviewDTO entityToDto(Review review) {
        ReviewDTO dto = new ReviewDTO();
        dto.setId(review.getId());
        dto.setBookId(review.getBookId());
        dto.setContent(review.getContent());
        dto.setPublishedDate(review.getPublishedDate());
        dto.setRating(review.getRating());
        dto.setReviewerName(review.getReviewerName());
        return dto;
    }

    public Review requestDTOtoEntity(ReviewRequestDTO dto) {
        Review review = new Review();
        review.setBookId(dto.getBookId());
        review.setContent(dto.getContent());
        review.setPublishedDate(dto.getPublishedDate()); //set to current timestamp
        review.setRating(dto.getRating());
        review.setReviewerName(dto.getReviewerName());
        return review;
    }

    public Review dtoToEntity(ReviewDTO dto) {
        Review review = new Review();
        review.setId(dto.getId());
        review.setBookId(dto.getBookId());
        review.setContent(dto.getContent());
        review.setPublishedDate(dto.getPublishedDate()==null?
                new Date(System.currentTimeMillis()):dto.getPublishedDate()); //set to current timestamp
        review.setRating(dto.getRating());
        review.setReviewerName(dto.getReviewerName());
        return review;
    }
}
