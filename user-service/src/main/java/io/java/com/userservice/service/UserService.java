package io.java.com.userservice.service;

import io.java.com.userservice.dto.ResponseDto;
import io.java.com.userservice.model.User;

public interface UserService {
    User saveUser(User user);

    ResponseDto getUser(Long userId);
}
