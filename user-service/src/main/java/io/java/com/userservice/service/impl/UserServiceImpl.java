package io.java.com.userservice.service.impl;

import io.java.com.userservice.dto.DepartmentDto;
import io.java.com.userservice.dto.ResponseDto;
import io.java.com.userservice.dto.UserDto;
import io.java.com.userservice.exception.ResourceNotFoundException;
import io.java.com.userservice.model.User;
import io.java.com.userservice.repository.UserRepository;
import io.java.com.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RestTemplate restTemplate;


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseDto getUser(Long userId) {
        ResponseDto responseDto = new ResponseDto();
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("This User not found with id " + userId)
        );
        UserDto userDto = mapToUser(user);
        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8081/api/departments/" + user.getDepartmentId(), DepartmentDto.class);
        DepartmentDto dto = responseEntity.getBody();
        responseDto.setUser(userDto);
        responseDto.setDepartment(dto);
        return responseDto;
    }

    private UserDto mapToUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
