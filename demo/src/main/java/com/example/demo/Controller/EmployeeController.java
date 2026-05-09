package com.example.demo.Controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
    return employeeService.getEmployeeById(id);
}
    @GetMapping("/search")
public List<Employee> searchEmployee(
        @RequestParam String name) {

    return employeeService.searchByName(name);
}

    @GetMapping("/role/{role}")
public List<Employee> getByRole(
        @PathVariable String role) {

    return employeeService.searchByRole(role);
}

    @GetMapping("/high-salary")
public List<Employee> getHighSalaryEmployees(
        @RequestParam double amount) {

    return employeeService
            .getHighSalaryEmployees(amount);
}

    @PostMapping
    public String addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PostMapping("/all")
    public String addEmployees(@RequestBody List<Employee> employees) {
    return "Employees added: " + employees.size();
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
    return employeeService.deleteEmployee(id);
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable Long id,
                             @RequestBody Employee employee) {
    return employeeService.updateEmployee(id, employee);
}
}