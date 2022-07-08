package com.example.springbootrest.DAO;

import com.example.springbootrest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByName(String name);

    @Query(value = "select e from Employee e where e.name = ?1 and e.surname = ?2")
    Employee findByNameAndAndSurname(String name, String surname);

    List<Employee> searchEmployeesBySalaryIsBetween(Integer salaryFrom, Integer salaryTo);

    @Modifying
    @Query(value = """
            update Employee e set e.name = ?1, e.surname = ?2, e.salary = ?3,
            e.department = ?4 where e.id = ?5
             """)
    void updateEmployee(String name, String surname, Integer salary,
                        String department, Integer userId);
}
