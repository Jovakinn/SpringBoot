package com.example.springbootrest.Service.interfaces;

import com.example.springbootrest.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployee(Integer id);
    void deleteEmployee(Integer id);
    List<Employee> findAllByName(String name);
    Employee findByNameAndAndSurname(String name, String surname);
}
