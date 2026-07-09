package com.cognizant.employeemanagementapi.service;

import com.cognizant.employeemanagementapi.dao.EmployeeDao;
import com.cognizant.employeemanagementapi.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public ArrayList<Employee> getAllEmployees() {

        LOGGER.info("START");

        ArrayList<Employee> employees =
                employeeDao.getAllEmployees();

        LOGGER.debug("Employees: {}", employees);
        LOGGER.info("END");

        return employees;
    }
    public void updateEmployee(Employee employee) {

        LOGGER.info("START");

        employeeDao.updateEmployee(employee);

        LOGGER.info("END");
    }
    public void deleteEmployee(Integer id) {

        LOGGER.info("START");

        employeeDao.deleteEmployee(id);

        LOGGER.info("END");
    }
}