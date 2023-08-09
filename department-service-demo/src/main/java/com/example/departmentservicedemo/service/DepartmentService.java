package com.example.departmentservicedemo.service;

import com.example.departmentservicedemo.model.Department;

public interface DepartmentService {

    public void save(Department department);

    public Department getDepartment(Long id);
}
