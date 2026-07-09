package com.cognizant.orm.learn.service;

import com.cognizant.orm.learn.model.Employee;
import com.cognizant.orm.learn.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.orm.learn.model.Department;
import com.cognizant.orm.learn.repository.DepartmentRepository;
import com.cognizant.orm.learn.model.Skill;
import com.cognizant.orm.learn.repository.SkillRepository;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final SkillRepository skillRepository;

    public EmployeeService(EmployeeRepository employeeRepository,DepartmentRepository departmentRepository,
                           SkillRepository skillRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.skillRepository = skillRepository ;
    }

    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found with id: " + id));
    }
    @Transactional
    public Employee addEmployee(Employee employee, int departmentId) {

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Department not found with id: " + departmentId
                        ));

        employee.setDepartment(department);

        return employeeRepository.save(employee);
    }
    @Transactional
    public Employee updateEmployee(
            int id,
            Employee updatedEmployee,
            int departmentId) {

        Employee existingEmployee = getEmployeeById(id);

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Department not found with id: " + departmentId
                        ));

        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setSalary(updatedEmployee.getSalary());
        existingEmployee.setPermanent(updatedEmployee.isPermanent());
        existingEmployee.setDateOfBirth(updatedEmployee.getDateOfBirth());
        existingEmployee.setDepartment(department);

        return employeeRepository.save(existingEmployee);
    }
    @Transactional
    public Employee addSkillToEmployee(int employeeId, int skillId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Employee not found with id: " + employeeId
                        ));

        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Skill not found with id: " + skillId
                        ));

        employee.getSkillList().add(skill);

        return employeeRepository.save(employee);
    }
    @Transactional(readOnly = true)
    public List<Employee> getAllPermanentEmployees() {
        return employeeRepository.getAllPermanentEmployees();
    }
    @Transactional(readOnly = true)
    public List<Employee> getAllPermanentEmployeesWithDetails() {
        return employeeRepository.getAllPermanentEmployeesWithDetails();
    }
}