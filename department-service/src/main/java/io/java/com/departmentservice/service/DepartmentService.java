package io.java.com.departmentservice.service;

import io.java.com.departmentservice.entity.Department;
import io.java.com.departmentservice.exception.ResourceNotFoundException;

public interface DepartmentService {
    Department saveDepartment(Department department);

    Department getDepartmentById(Long departmentId);

}
