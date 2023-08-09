package com.example.springbootjunitdemo.repo;

import com.example.springbootjunitdemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
