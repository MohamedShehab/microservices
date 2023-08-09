package com.example.departmentservicedemo.service.impl;

import com.example.departmentservicedemo.model.Department;
import com.example.departmentservicedemo.repo.DepartmentRepo;
import com.example.departmentservicedemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public void save(Department department) {
        Department savedDepartment = new Department();
        savedDepartment.setDepartmentName(department.getDepartmentName());
        savedDepartment.setDepartmentAddress(department.getDepartmentAddress());
        savedDepartment.setDepartmentCode(department.getDepartmentCode());
        departmentRepo.save(savedDepartment);
    }

    @Override
    public Department getDepartment(Long id) {
        return departmentRepo.findById(id).orElseThrow();
    }
}
