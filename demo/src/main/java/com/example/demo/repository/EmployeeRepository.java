package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {
                List<Employee> findByName(String name);
                List<Employee> findByRole(String role);
                List<Employee> findBySalaryGreaterThan(double amount);
}