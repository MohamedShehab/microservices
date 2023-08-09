package com.example.userservicedemo.controller;

import com.example.userservicedemo.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "DEPARTMENT-SERVICE", url = "http://localhost:8888",path = "/api/departments")
public interface APIDepartmentClient {

    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartmentDto> getById(@PathVariable Long id);
}
