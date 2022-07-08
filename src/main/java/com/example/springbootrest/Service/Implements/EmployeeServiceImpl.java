package com.example.springbootrest.Service.Implements;

import com.example.springbootrest.DAO.EmployeeRepository;
import com.example.springbootrest.DTO.EmployeeDto;
import com.example.springbootrest.Service.interfaces.EmployeeService;
import com.example.springbootrest.entity.Employee;
import com.example.springbootrest.exception_handling.NoSuchEmployeesException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(this::convertEntityToDto)
                .toList();
    }

    @Override
    public void saveEmployee(EmployeeDto employeeDto) {
        Employee employee = convertDtoToEntity(employeeDto);
        employeeRepository.save(employee);
    }

    @Override
    public EmployeeDto getEmployee(Integer id) {
        Employee employee = null;
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()) {
            employee = optionalEmployee.get();
        }
        return convertEntityToDto(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDto> findAllByName(String name) {
        List<Employee> employees = employeeRepository.findAllByName(name);
        return employees.stream()
                .map(this::convertEntityToDto)
                .toList();
    }

    @Override
    public EmployeeDto findByNameAndAndSurname(String name, String surname) {
        Employee employee = employeeRepository.findByNameAndAndSurname(name, surname);
        return convertEntityToDto(employee);
    }

    @Override
    public List<EmployeeDto> searchEmployeesBySalaryIsBetween(Integer salaryFrom, Integer salaryTo) {
        List<Employee> employees = employeeRepository.searchEmployeesBySalaryIsBetween(salaryFrom, salaryTo);
        if (employees.isEmpty()) {
            throw new NoSuchEmployeesException("No employees present here",new Throwable());
        }
        return employees.stream()
                .map(this::convertEntityToDto)
                .toList();
    }

    @Override
    @Transactional
    public void updateEmployee(EmployeeDto employeeDto) {
        employeeRepository.updateEmployee(employeeDto.getName(), employeeDto.getSurname(),
                employeeDto.getSalary(), employeeDto.getDepartment(), employeeDto.getId());
    }

    @Override
    public EmployeeDto convertEntityToDto(Employee employee) {
        configureModelMapper();
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public Employee convertDtoToEntity(EmployeeDto employeeDto) {
        configureModelMapper();
        return modelMapper.map(employeeDto, Employee.class);
    }

    private void configureModelMapper() {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
    }
}
