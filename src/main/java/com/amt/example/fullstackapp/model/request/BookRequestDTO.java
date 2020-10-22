package com.amt.example.fullstackapp.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

public class BookRequestDTO {

    private Long id;

    @JsonProperty(required = true)
    @NotBlank
    private String title;

    @JsonProperty(required = true)
    @NotBlank
    private String author;

    @JsonProperty(required = true)
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate publishedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
