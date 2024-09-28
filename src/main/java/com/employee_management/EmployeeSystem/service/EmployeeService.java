package com.employee_management.EmployeeSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee_management.EmployeeSystem.model.Employee;
import com.employee_management.EmployeeSystem.repository.EmployeeRepository;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository EmployeeRepository;
	
	public List<Employee> getAllEmployees(){
		return EmployeeRepository.findAll();
	}
	
	public Employee getEmployee(Long Id) {
		return EmployeeRepository.findById(Id).orElse(null);
	}
	@Transactional
	public void saveEmployee(Employee object) {
		EmployeeRepository.save(object);
	}
	
	public void updateEmployee(Long Id,Employee newObject) {
		Employee oldObject=EmployeeRepository.findById(Id).orElse(null);
		oldObject.setAll(newObject);
		EmployeeRepository.save(oldObject);
	}
	
	public void deleteEmployee(Long Id) {
		EmployeeRepository.deleteById(Id);
	}
}
