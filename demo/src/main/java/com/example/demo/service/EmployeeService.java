package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.repository.EmployeeRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();
    private final EmployeeRepository employeeRepository;
    
        public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

}

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public String addEmployee(Employee employee) {

        employeeRepository.save(employee);
        return "Employee added successfully!";
    }

    public Employee getEmployeeById(Long id) {

    return employeeRepository.findById(id)
            .orElseThrow(() ->
                    new EmployeeNotFoundException(
                            "Employee not found with id: " + id));
}

    public String deleteEmployee(Long id) {

    employeeRepository.deleteById(id);

    return "Employee deleted successfully!";
}

    public String updateEmployee(Long id, Employee updatedEmployee) {

    Employee employee = employeeRepository.findById(id).orElse(null);

    if (employee != null) {

        employee.setName(updatedEmployee.getName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setRole(updatedEmployee.getRole());
        employee.setSalary(updatedEmployee.getSalary());

        employeeRepository.save(employee);

        return "Employee updated successfully!";
    }

    return "Employee not found!";
}
    public List<Employee> searchByName(String name) {

    return employeeRepository.findByName(name);
}
    public List<Employee> searchByRole(String role) {

    return employeeRepository.findByRole(role);
}
    public List<Employee> getHighSalaryEmployees(
        double amount) {

    return employeeRepository
            .findBySalaryGreaterThan(amount);
}

}