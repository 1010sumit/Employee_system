package com.employee_management.EmployeeSystem.model;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String first_name;
	private String last_name;
	private Long mobile_no;
	private String email_id;
	private String department;
	private Integer salary;
	private Long bank_account_no;
	@CreationTimestamp
	private Instant createdOn;
	@UpdateTimestamp 
	private Instant updatedOn;
	
	public Employee(){}
	public Employee(Employee object){
		this.first_name=object.getFirst_name();
		this.last_name=object.getLast_name();
		this.mobile_no=object.getMobile_no();
		this.email_id=object.getEmail_id();
		this.department=object.getDepartment();
		this.bank_account_no=object.getBank_account_no();
		this.salary = object.getSalary();
	}
	public Long getId() {
		return id;
	}
	
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	
	public Long getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(Long mobile_no) {
		this.mobile_no = mobile_no;
	}
	
	
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	public Long getBank_account_no() {
		return bank_account_no;
	}
	public void setBank_account_no(Long bank_account_no) {
		this.bank_account_no = bank_account_no;
	}
	
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	
	public void setAll(Employee object){
		this.first_name=object.getFirst_name();
		this.last_name=object.getLast_name();
		this.mobile_no=object.getMobile_no();
		this.email_id=object.getEmail_id();
		this.department=object.getDepartment();
		this.bank_account_no=object.getBank_account_no();
		this.salary = object.getSalary();
	}
	
	
}
