package com.example.springbootrest.controllers;

import com.example.springbootrest.Service.interfaces.EmployeeService;
import com.example.springbootrest.entity.Employee;
import com.example.springbootrest.exception_handling.NoSuchEmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable String employeeId) {
        Employee employee = employeeService.getEmployee(Integer.valueOf(employeeId));
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + employeeId + " " +
                    "in Database");
        }

        return employee;
    }

    @GetMapping("/employees/{employeeName}/{employeeSurname}")
    public Employee getEmployeeByNameAndSurname(@PathVariable String employeeName,
                                                @PathVariable String employeeSurname) {
        Employee employee = employeeService.findByNameAndAndSurname(employeeName, employeeSurname);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with NAME = " + employeeName +
                    " and SURNAME = " + employeeSurname + " in DB!");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " +
                    id + " in Database");
        }

        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was successfully deleted";
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> showAllEmployeesByName(@PathVariable String name) {
        return employeeService.findAllByName(name);
    }
}
