package com.example.springbootrest.Service.Implements;

import com.example.springbootrest.DAO.DepartmentRepository;
import com.example.springbootrest.Service.interfaces.IDepartmentService;
import com.example.springbootrest.entity.Department;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService implements IDepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
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
