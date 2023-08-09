package com.example.springbootjunitdemo;

import com.example.springbootjunitdemo.controller.UserController;
import com.example.springbootjunitdemo.dto.UserDto;
import com.example.springbootjunitdemo.exception.UserNotFoundException;
import com.example.springbootjunitdemo.models.User;
import com.example.springbootjunitdemo.models.UserDtoTest;
import com.example.springbootjunitdemo.repo.UserRepo;
import com.example.springbootjunitdemo.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
//@MockitoSettings(strictness = Strictness.LENIENT)
public class UserControllerTest {
    @Mock
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private UserController userController;

    @Test
    @DisplayName("save user!")
    public void saveUser() {
        UserDto userDto = UserDtoTest.userDto();
        User user = UserDtoTest.user();
        when(userRepo.save(user)).thenReturn(user);
        ResponseEntity<HttpStatus> actual = userController.save(userDto);
        Assertions.assertEquals(HttpStatus.CREATED, actual.getStatusCode());
    }

    @Test
    @DisplayName("find user with valid id.")
    public void findUser() {
        User user = UserDtoTest.user();
        when(userRepo.findById(1L)).thenReturn(Optional.of(user));
        ResponseEntity<User> actual = userController.getUser(1L);
        Assertions.assertEquals(HttpStatus.OK, actual.getStatusCode());
        Assertions.assertEquals(user.getFirstName(), Objects.requireNonNull(actual.getBody()).getFirstName());
        Assertions.assertEquals(user.getLastName(), Objects.requireNonNull(actual.getBody()).getLastName());

    }

    @Test
    @DisplayName("find user with invalid id.")
    public void findUserWithInvalid() {
        when(userRepo.findById(-1L)).thenReturn(Optional.ofNullable(null));
        var actual = Assertions.assertThrows(UserNotFoundException.class, () ->
                userController.getUser(-1L));
        Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), actual.getStatusCode());
    }

    @Test
    @DisplayName("list of users")
    public void listUsers() {
        List<User> list = new ArrayList<>();
        User user1 = new User(1L, "Ahmed", "Hassan", "ahmed@gmail.com", "Cairo");
        User user2 = new User(2L, "noor", "Hassan", "ahmed@gmail.com", "Naser");
        User user3 = new User(3L, "Hamdy", "Hassan", "ahmed@gmail.com", "Zigzag");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        when(userRepo.findAll()).thenReturn(list);
        List<User> users = userController.findAll().getBody();
        Assertions.assertEquals(list.size(), users.size());
        for (User user : users) {
            for (User listUser : list) {
                Assertions.assertEquals(user.getFirstName(), listUser.getFirstName());
            }
        }
    }

    @Test
    public void whenAssertingConditions_thenVerified() {
        assertTrue(5 > 4, "5 is greater the 4");
        assertTrue(null == null, "null is equal to null");
    }

    @Test
    public void whenAssertingSameObject_thenSuccessfull() {
        String language = "Java";
        Optional<String> optional = Optional.of(language);

        assertSame(language, optional.get());
    }
}