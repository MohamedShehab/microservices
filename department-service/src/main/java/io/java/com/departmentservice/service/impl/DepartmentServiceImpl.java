package io.java.com.departmentservice.service.impl;

import io.java.com.departmentservice.entity.Department;
import io.java.com.departmentservice.exception.ResourceNotFoundException;
import io.java.com.departmentservice.repository.DepartmentRepository;
import io.java.com.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department not found with id: " + departmentId)
        );
    }
}
