package com.cognizant.employeemanagementapi.controller;

import com.cognizant.employeemanagementapi.model.Employee;
import com.cognizant.employeemanagementapi.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;

@RestController
public class EmployeeController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ArrayList<Employee> getAllEmployees() {

        LOGGER.info("START");

        ArrayList<Employee> employees =
                employeeService.getAllEmployees();

        LOGGER.info("END");

        return employees;
    }
    @PutMapping("/employees")
    public void updateEmployee(@Valid @RequestBody Employee employee) {

        LOGGER.info("START");
        LOGGER.debug("Employee received: {}", employee);

        employeeService.updateEmployee(employee);

        LOGGER.info("END");
    }
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Integer id) {

        LOGGER.info("START");
        LOGGER.debug("Employee id: {}", id);

        employeeService.deleteEmployee(id);

        LOGGER.info("END");
    }
}