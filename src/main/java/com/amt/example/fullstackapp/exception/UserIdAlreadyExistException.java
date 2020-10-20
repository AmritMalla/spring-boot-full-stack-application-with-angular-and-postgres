package com.amt.example.fullstackapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Amrit Malla
 * date : 20/10/2020
 * time : 10:15 PM
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserIdAlreadyExistException extends RuntimeException {

    public UserIdAlreadyExistException(String s) {
        super(s);
    }
}
