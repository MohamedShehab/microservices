package com.example.springbootjunitdemo.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class UserNotFoundException extends RuntimeException {

    private String message;
    private int statusCode = HttpStatus.NOT_FOUND.value();

    public UserNotFoundException(String message) {
        super(message);
    }
}
