package com.employee_management.EmployeeSystem.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.employee_management.EmployeeSystem.model.Employee;
import com.employee_management.EmployeeSystem.service.EmployeeService;

@Controller
@RequestMapping("/employee_page")
public class EmployeeController {
	@Autowired
	private EmployeeService emp_service;
	
	
	@GetMapping("/")
    public String viewAllEmployee(Model model) {
        try {
            List<Employee> employees = emp_service.getAllEmployees();
            model.addAttribute("employees", employees);
            return "viewAllEmployee"; // Assuming "viewAllEmployee.jsp" is the name of your JSP file
        } catch (Exception e) {
            return "Error Page"; // Assuming you have an "error.jsp" for error cases
        }
    }
	
	@GetMapping("/viewEmployee/{id}")
	public String getEmployee(@PathVariable Long id, Model model){
		try {
			Employee employee=emp_service.getEmployee(id);
            model.addAttribute("employee", employee);
            return "viewEmployee";
		}catch(Exception e) {
			return "Error Page";
		}
	}
	@GetMapping("/checkEmployeeId/{id}")
    public boolean checkEmployeeId(@PathVariable Long id) {
        if(emp_service.getEmployee(id)!=null)
        	return true;
        return false;
    }
	
	@PostMapping("/addEmployee")
	public String saveEmployee(@ModelAttribute Employee emp) {//
	    try {
	        emp_service.saveEmployee(emp);
	        return "Success Page";
	    } catch (Exception e) {
	        System.out.println("Error: " + e);
	        return "Error Page";
	      }
	}
	
	@PutMapping("/updateEmployee/{id}")
	public String updateEmployee(@PathVariable Long id, @ModelAttribute Employee emp){
		try {
			emp_service.updateEmployee(id, emp);
			return "Success Page";
		}catch(Exception e) {
			System.out.println("Error : "+e);
			return "Error Page";
		}
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Long id){
		try {
			emp_service.deleteEmployee(id);
			return "Success Page";
		}catch(Exception e) {
			System.out.println("Error : "+e);
			return "Error Page";
		}
	}
}
