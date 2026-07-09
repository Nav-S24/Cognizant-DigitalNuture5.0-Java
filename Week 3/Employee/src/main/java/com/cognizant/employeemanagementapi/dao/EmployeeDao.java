package com.cognizant.employeemanagementapi.dao;

import com.cognizant.employeemanagementapi.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import com.cognizant.employeemanagementapi.service.exception.EmployeeNotFoundException;

import java.util.ArrayList;

@Repository
public class EmployeeDao {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeDao.class);

    private static ArrayList<Employee> EMPLOYEE_LIST;

    public EmployeeDao() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("employee.xml");

        EMPLOYEE_LIST =
                context.getBean("employeeList", ArrayList.class);

        LOGGER.debug("Employee List: {}", EMPLOYEE_LIST);
        LOGGER.info("END");
    }

    public ArrayList<Employee> getAllEmployees() {

        LOGGER.info("START");
        LOGGER.debug("Employee List: {}", EMPLOYEE_LIST);
        LOGGER.info("END");

        return EMPLOYEE_LIST;
    }
    public void updateEmployee(Employee employee) {

        LOGGER.info("START");
        LOGGER.debug("Employee to update: {}", employee);

        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {

            if (EMPLOYEE_LIST.get(i).getId().equals(employee.getId())) {

                EMPLOYEE_LIST.set(i, employee);

                LOGGER.debug("Employee updated: {}", employee);
                LOGGER.info("END");
                return;
            }
        }

        LOGGER.info("Employee not found");
        throw new EmployeeNotFoundException();
    }
    public void deleteEmployee(Integer id) {

        LOGGER.info("START");
        LOGGER.debug("Employee id to delete: {}", id);

        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {

            if (EMPLOYEE_LIST.get(i).getId().equals(id)) {

                EMPLOYEE_LIST.remove(i);

                LOGGER.info("Employee deleted successfully");
                LOGGER.info("END");
                return;
            }
        }

        LOGGER.info("Employee not found");
        throw new EmployeeNotFoundException();
    }
}