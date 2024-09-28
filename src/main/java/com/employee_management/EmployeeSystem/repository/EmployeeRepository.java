package com.employee_management.EmployeeSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_management.EmployeeSystem.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
