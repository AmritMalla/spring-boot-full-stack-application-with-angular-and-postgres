package com.amt.example.fullstackapp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(value = "reviews")
public class Review {
    @Id
    @Column
    private long id;

    @Column
    private long bookId;

    @Column
    private String reviewerName;

    @Column
    private String content;

    @Column
    private int rating;

    @Column
    private LocalDateTime publishedDate;

    public Review() {
    }

    public Review(long id, long bookId, String reviewerName, String content, int rating, LocalDateTime publishedDate) {
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
