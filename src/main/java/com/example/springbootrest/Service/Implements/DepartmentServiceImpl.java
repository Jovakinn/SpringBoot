package com.example.springbootrest.Service.Implements;

import com.example.springbootrest.DAO.DepartmentRepository;
import com.example.springbootrest.Service.interfaces.DepartmentService;
import com.example.springbootrest.entity.Department;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department findDepartmentById(Integer departmentId) {
        return departmentRepository.findDepartmentById(departmentId);
    }
}
