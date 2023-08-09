package io.java.com.userservice.controller;

import io.java.com.userservice.dto.ResponseDto;
import io.java.com.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserResource {

    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseDto> getUserDepartments(@PathVariable Long userId) {
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.FOUND);
    }
}
