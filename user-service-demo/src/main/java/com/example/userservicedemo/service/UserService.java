package com.example.userservicedemo.service;


import com.example.userservicedemo.dto.ResponseDto;
import com.example.userservicedemo.model.User;

public interface UserService {

    public void save(User user);

    public ResponseDto getUser(Long id);
}
