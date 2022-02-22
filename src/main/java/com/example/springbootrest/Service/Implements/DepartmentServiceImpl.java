package com.example.springbootrest.Service.Implements;

import com.example.springbootrest.DAO.Interfaces.DepartmentRepository;
import com.example.springbootrest.Service.interfaces.DepartmentService;
import com.example.springbootrest.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department findDepartmentById(Integer departmentId) {
        return departmentRepository.findDepartmentById(departmentId);
    }
}
