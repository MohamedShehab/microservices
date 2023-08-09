package com.example.springbootjunitdemo.models;

import com.example.springbootjunitdemo.dto.UserDto;

public class UserDtoTest {

    public static User user() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("Mohamed");
        user.setLastName("Shehab");
        user.setEmail("moahmed@gmail.com");
        user.setAddress("cairo");
        return user;
    }


    public static UserDto userDto() {
        UserDto userDto = new UserDto();
        userDto.setId(1L);
        userDto.setFirstName("Mohamed");
        userDto.setLastName("Shehab");
        userDto.setEmail("moahmed@gmail.com");
        userDto.setAddress("cairo");
        return userDto;
    }


}
