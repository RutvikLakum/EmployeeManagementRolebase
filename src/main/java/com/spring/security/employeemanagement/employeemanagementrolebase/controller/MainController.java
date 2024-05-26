package com.spring.security.employeemanagement.employeemanagementrolebase.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.security.employeemanagement.employeemanagementrolebase.model.Employee;
import com.spring.security.employeemanagement.employeemanagementrolebase.repository.EmployeeRepository;



@Controller
public class MainController {

	@Autowired
	private EmployeeRepository employeedao;

	@GetMapping("/")
	public String viewEmployee(Model model) {
		List<Employee> employee = employeedao.findAll();
		model.addAttribute("employee", employee);
		return "viewEmployee";
	}

	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());

		return "addEmployee";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee employee) {
		employeedao.save(employee);
		return "redirect:/";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/editEmployee/{id}")
	public String editEmployee(@PathVariable("id") int emp_id, Model model) {

		Employee employee = employeedao.findById(emp_id).get();
		model.addAttribute("employee", employee);
		return "updateEmployee";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") int emp_id, Model model) {

		employeedao.deleteById(emp_id);
		return "redirect:/";
	}

	@GetMapping("/signin")
	public String showLoginForm() {
		return "login"; // This will return login.html or the appropriate login page
	}
	
}
