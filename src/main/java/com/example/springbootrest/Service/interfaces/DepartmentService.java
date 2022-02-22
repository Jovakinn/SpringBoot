package com.example.springbootrest.Service.interfaces;

import com.example.springbootrest.entity.Department;

public interface DepartmentService {
    Department saveDepartment(Department department);
    Department findDepartmentById(Integer departmentId);
}
