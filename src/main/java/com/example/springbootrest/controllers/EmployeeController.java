package com.example.springbootrest.controllers;

import com.example.springbootrest.DTO.EmployeeDto;
import com.example.springbootrest.Service.interfaces.EmployeeService;
import com.example.springbootrest.exception_handling.NoSuchEmployeeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employee_service")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<EmployeeDto> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public EmployeeDto getEmployee(@PathVariable String employeeId) {
        EmployeeDto employee = employeeService.getEmployee(Integer.valueOf(employeeId));
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + employeeId + " " +
                    "in Database", new Throwable());
        }
        return employee;
    }

    @GetMapping("/employees/{employeeName}/{employeeSurname}")
    public EmployeeDto getEmployeeByNameAndSurname(@PathVariable String employeeName,
                                                @PathVariable String employeeSurname) {
        EmployeeDto employee = employeeService.findByNameAndAndSurname(employeeName, employeeSurname);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with NAME = " + employeeName +
                    " and SURNAME = " + employeeSurname + " in DB!", new Throwable());
        }
        return employee;
    }

    @PostMapping("/employees/add")
    public void addNewEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeService.saveEmployee(employeeDto);
    }

    @PutMapping("/employees/update")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeService.updateEmployee(employeeDto);
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        EmployeeDto employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " +
                    id + " in Database", new Throwable());
        }

        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was successfully deleted";
    }

    @GetMapping("/employees/name/{name}")
    public List<EmployeeDto> showAllEmployeesByName(@PathVariable String name) {
        return employeeService.findAllByName(name);
    }

    @GetMapping("/employees/salary_search")
    public List<EmployeeDto> showAllEmployeesBySalaryBetween(
            @RequestParam Integer salaryFrom, @RequestParam Integer salaryTo
    ) {
        return employeeService.searchEmployeesBySalaryIsBetween(salaryFrom, salaryTo);
    }
}
