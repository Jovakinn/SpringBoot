package com.example.springbootrest.Service.interfaces;

import com.example.springbootrest.DTO.EmployeeDto;
import com.example.springbootrest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();
    void saveEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployee(Integer id);
    void deleteEmployee(Integer id);
    List<EmployeeDto> findAllByName(String name);
    EmployeeDto findByNameAndAndSurname(String name, String surname);
    List<EmployeeDto> searchEmployeesBySalaryIsBetween(Integer salaryFrom, Integer salaryTo);
    void updateEmployee(EmployeeDto employeeDto);
    EmployeeDto convertEntityToDto(Employee employee);
    Employee convertDtoToEntity(EmployeeDto employeeDto);
}
