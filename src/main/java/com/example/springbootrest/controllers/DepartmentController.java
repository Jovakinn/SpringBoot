package com.example.springbootrest.controllers;

import com.example.springbootrest.Service.interfaces.DepartmentService;
import com.example.springbootrest.entity.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService DepartmentService) {
        this.departmentService = DepartmentService;
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
