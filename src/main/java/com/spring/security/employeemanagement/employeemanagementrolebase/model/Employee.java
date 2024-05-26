package com.spring.security.employeemanagement.employeemanagementrolebase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emp_id;
	private String emp_name;
	private String emp_email;
	private String emp_mobile;
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	public String getEmp_mobile() {
		return emp_mobile;
	}
	public void setEmp_mobile(String emp_mobile) {
		this.emp_mobile = emp_mobile;
	}
	public Employee(int emp_id, String emp_name, String emp_email, String emp_mobile) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_email = emp_email;
		this.emp_mobile = emp_mobile;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}
