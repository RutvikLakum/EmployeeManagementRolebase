package com.spring.security.employeemanagement.employeemanagementrolebase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.employeemanagement.employeemanagementrolebase.model.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
