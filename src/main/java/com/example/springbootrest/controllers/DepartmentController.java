package com.example.springbootrest.controllers;

import com.example.springbootrest.Service.interfaces.IDepartmentService;
import com.example.springbootrest.entity.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    private final IDepartmentService departmentService;

    public DepartmentController(IDepartmentService IDepartmentService) {
        this.departmentService = IDepartmentService;
    }

    @PostMapping("/save")
    public Department saveDepartment(@RequestBody Department department){
        log.info("inside save department");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Integer departmentId) {
        log.info("inside find department by id");
        return departmentService.findDepartmentById(departmentId);
    }
}
