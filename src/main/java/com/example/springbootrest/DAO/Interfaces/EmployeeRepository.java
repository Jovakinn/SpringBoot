package com.example.springbootrest.DAO.Interfaces;

import com.example.springbootrest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByName(String name);
    @Query("select e from Employee e where e.name = ?1 and e.surname = ?2")
    Employee findByNameAndAndSurname(String name, String surname);
}
