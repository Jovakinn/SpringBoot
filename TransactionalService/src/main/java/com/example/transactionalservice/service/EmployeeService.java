package com.example.transactionalservice.service;

import com.example.transactionalservice.entity.Department;
import com.example.transactionalservice.entity.Employee;
import com.example.transactionalservice.repository.DepartmentRepository;
import com.example.transactionalservice.repository.EmployeeRepository;
import com.example.transactionalservice.vo.EmployeeRequestVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public String saveEmployee(EmployeeRequestVO employeeRequestVO) {
        var department = new Department();
        department.setDepartmentName(employeeRequestVO.getDepartmentName());
        department.setDepartmentCode(employeeRequestVO.getDepartmentCode());

        var departmentId = departmentRepository.save(department).getDepartmentId();
        var employee = new Employee();
        employee.setEmployeeName(employeeRequestVO.getEmployeeName());
        employee.setDepartmentId(departmentId);

        employeeRepository.save(employee);

        return "Employee with ID: " + employee.getEmployeeId() +" has been successfully saved to db";
    }
}
