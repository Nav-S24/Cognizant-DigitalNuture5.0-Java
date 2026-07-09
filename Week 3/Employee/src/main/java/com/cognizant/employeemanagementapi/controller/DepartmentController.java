package com.cognizant.employeemanagementapi.controller;

import com.cognizant.employeemanagementapi.model.Department;
import com.cognizant.employeemanagementapi.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class DepartmentController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public ArrayList<Department> getAllDepartments() {

        LOGGER.info("START");

        ArrayList<Department> departments =
                departmentService.getAllDepartments();

        LOGGER.info("END");

        return departments;
    }
}