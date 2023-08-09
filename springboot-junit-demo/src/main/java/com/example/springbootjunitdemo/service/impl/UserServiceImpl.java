package com.example.springbootjunitdemo.service.impl;

import com.example.springbootjunitdemo.dto.UserDto;
import com.example.springbootjunitdemo.exception.UserNotFoundException;
import com.example.springbootjunitdemo.models.User;
import com.example.springbootjunitdemo.repo.UserRepo;
import com.example.springbootjunitdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void save(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAddress());
        userRepo.save(user);
    }

    @Override
    public User getUser(Long id) {
        User user = userRepo.findById(id).orElseThrow(
                () -> new UserNotFoundException("User not found.")
        );
        return user;
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }
}
