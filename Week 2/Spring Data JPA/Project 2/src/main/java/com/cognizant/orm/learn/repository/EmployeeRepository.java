package com.cognizant.orm.learn.repository;

import com.cognizant.orm.learn.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT e FROM Employee e WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();

    @Query("""
            SELECT DISTINCT e
            FROM Employee e
            JOIN FETCH e.department
            LEFT JOIN FETCH e.skillList
            WHERE e.permanent = true
            """)
    List<Employee> getAllPermanentEmployeesWithDetails();
}