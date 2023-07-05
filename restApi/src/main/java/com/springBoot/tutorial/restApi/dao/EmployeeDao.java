package com.springBoot.tutorial.restApi.dao;

import java.util.List;
import com.springBoot.tutorial.restApi.entity.Employee;

public interface EmployeeDao {
	public List<Employee> findAll();
	public Employee findById(int id);
	public Employee insert(Employee obj);
	public void delete(int id);
}
