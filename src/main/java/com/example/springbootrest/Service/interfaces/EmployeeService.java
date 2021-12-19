package com.example.springbootrest.Service.interfaces;

import com.example.springbootrest.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);
    public Employee getEmployee(Integer id);
    public void deleteEmployee(Integer id);
    public List<Employee> findAllByName(String name);
}
