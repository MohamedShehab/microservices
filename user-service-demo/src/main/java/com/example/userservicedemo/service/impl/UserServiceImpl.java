package com.example.userservicedemo.service.impl;

import com.example.userservicedemo.controller.APIDepartmentClient;
import com.example.userservicedemo.dto.DepartmentDto;
import com.example.userservicedemo.dto.ResponseDto;
import com.example.userservicedemo.dto.UserDto;
import com.example.userservicedemo.model.User;
import com.example.userservicedemo.repo.UserRepo;
import com.example.userservicedemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    private APIDepartmentClient apiDepartmentClient;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, APIDepartmentClient apiDepartmentClient) {
        this.userRepo = userRepo;
        this.apiDepartmentClient = apiDepartmentClient;
    }

    @Override
    public void save(User user) {
        User savedUser = new User();
        savedUser.setFirstName(user.getFirstName());
        savedUser.setLastName(user.getLastName());
        savedUser.setEmail(user.getEmail());
        userRepo.save(savedUser);
    }

    @Override
    public ResponseDto getUser(Long id) {
        User user = userRepo.findById(id).orElseThrow();
        DepartmentDto departmentDto = apiDepartmentClient.getById(user.getId()).getBody();
        ResponseDto responseDto = new ResponseDto();
        responseDto.setUser(mapToUserDto(user));
        responseDto.setDepartment(departmentDto);
        return responseDto;
    }

    private static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
