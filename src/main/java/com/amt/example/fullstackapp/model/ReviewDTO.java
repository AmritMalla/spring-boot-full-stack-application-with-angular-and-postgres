package com.amt.example.fullstackapp.model;

import java.time.LocalDateTime;


/**
 * Created by Amrit Malla
 * date : 13/10/2020
 * time : 12:01 PM
 */
public class ReviewDTO {

    private long id;

    private long bookId;

    private String reviewerName;

    private String content;

    private int rating;

    private LocalDateTime publishedDate;

    public ReviewDTO() {
    }

    public ReviewDTO(long id, long bookId, String reviewerName, String content, int rating, LocalDateTime publishedDate) {
        this.id = id;
        this.bookId = bookId;
        this.reviewerName = reviewerName;
        this.content = content;
        this.rating = rating;
        this.publishedDate = publishedDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }
}
