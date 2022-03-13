package com.example.springbootrest.DAO;

import com.example.springbootrest.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Department findDepartmentById(Integer id);
}
