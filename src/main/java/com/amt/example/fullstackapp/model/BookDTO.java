package com.amt.example.fullstackapp.model;

import java.time.LocalDate;

/**
 * Created by Amrit Malla
 * date : 13/10/2020
 * time : 12:01 PM
 */
public class BookDTO {

    private long id;

    private String title;

    private String author;

    private LocalDate publishedDate;

    public BookDTO() {
    }

    public BookDTO(long id, String title, String author, LocalDate publishedDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
}
