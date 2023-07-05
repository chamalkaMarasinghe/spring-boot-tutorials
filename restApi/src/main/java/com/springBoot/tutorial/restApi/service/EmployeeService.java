package com.springBoot.tutorial.restApi.service;

import java.util.List;

import com.springBoot.tutorial.restApi.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findById(int id);
	public Employee insert(Employee employee);
	public void delete(int id);
}
