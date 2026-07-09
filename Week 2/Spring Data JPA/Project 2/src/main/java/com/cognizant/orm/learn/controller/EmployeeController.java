package com.cognizant.orm.learn.controller;

import com.cognizant.orm.learn.model.Employee;
import com.cognizant.orm.learn.service.EmployeeService;
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
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee addEmployee(
            @RequestBody Employee employee,
            @RequestParam int departmentId) {

        return employeeService.addEmployee(employee, departmentId);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable int id,
            @RequestParam int departmentId,
            @RequestBody Employee employee) {

        return employeeService.updateEmployee(
                id,
                employee,
                departmentId
        );
    }
    @PostMapping("/{employeeId}/skills/{skillId}")
    public Employee addSkillToEmployee(
            @PathVariable int employeeId,
            @PathVariable int skillId) {

        return employeeService.addSkillToEmployee(employeeId, skillId);
    }
    @GetMapping("/permanent")
    public List<Employee> getAllPermanentEmployees() {
        return employeeService.getAllPermanentEmployees();
    }
    @GetMapping("/permanent/details")
    public List<Employee> getAllPermanentEmployeesWithDetails() {
        return employeeService.getAllPermanentEmployeesWithDetails();
    }
}