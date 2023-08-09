package com.example.springbootjunitdemo.service;

import com.example.springbootjunitdemo.dto.UserDto;
import com.example.springbootjunitdemo.models.User;

import java.util.List;

public interface UserService {

    public void save(UserDto userDto);

    public User getUser(Long id);

    public List<User> findAll();
}
