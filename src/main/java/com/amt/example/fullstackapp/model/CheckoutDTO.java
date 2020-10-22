package com.amt.example.fullstackapp.model;

import java.time.LocalDate;

/**
 * Created by Amrit Malla
 * date : 13/10/2020
 * time : 12:01 PM
 */
public class CheckoutDTO {

    private long id;

    private long userId;

    private long bookId;

    private LocalDate checkoutDate;

    private LocalDate returnDate;

    public CheckoutDTO() {
    }

    public CheckoutDTO(long id, long userId, long bookId, LocalDate checkoutDate, LocalDate returnDate) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.checkoutDate = checkoutDate;
        this.returnDate = returnDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
