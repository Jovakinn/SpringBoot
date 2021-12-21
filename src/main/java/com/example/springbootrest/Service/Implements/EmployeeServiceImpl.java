package com.example.springbootrest.Service.Implements;

import com.example.springbootrest.DAO.Interfaces.EmployeeRepository;
import com.example.springbootrest.Service.interfaces.EmployeeService;
import com.example.springbootrest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Integer id) {
        Employee employee = null;
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()) {
            employee = optionalEmployee.get();
        }
        return employee;
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByName(String name) {
        return employeeRepository.findAllByName(name);
    }

    @Override
    public Employee findByNameAndAndSurname(String name, String surname) {
        return employeeRepository.findByNameAndAndSurname(name, surname);
    }
}
