package com.springBoot.tutorial.restApi.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.tutorial.restApi.dao.EmployeeDao;
import com.springBoot.tutorial.restApi.entity.Employee;
import com.springBoot.tutorial.restApi.service.EmployeeService;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public Employee findById(@PathVariable int id) {
		return employeeService.findById(id);
	}
	
	@PostMapping("/employees")
	public Employee insertEmployee(@RequestBody Employee emp) {
		emp.setId(0);
		return employeeService.insert(emp);
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return employeeService.insert(emp);
	}
	
	@DeleteMapping("/employees/{id}")
	public void delete(@PathVariable int id) {
		employeeService.delete(id);
	}
}





