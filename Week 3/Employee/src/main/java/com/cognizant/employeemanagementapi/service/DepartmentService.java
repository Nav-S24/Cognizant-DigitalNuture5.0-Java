package com.cognizant.employeemanagementapi.service;

import com.cognizant.employeemanagementapi.dao.DepartmentDao;
import com.cognizant.employeemanagementapi.model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DepartmentService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentService.class);

    private final DepartmentDao departmentDao;

    public DepartmentService(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public ArrayList<Department> getAllDepartments() {

        LOGGER.info("START");

        ArrayList<Department> departments =
                departmentDao.getAllDepartments();

        LOGGER.info("END");

        return departments;
    }
}