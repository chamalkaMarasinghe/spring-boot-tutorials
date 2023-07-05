package com.springBoot.tutorial.restApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.tutorial.restApi.dao.EmployeeDao;
import com.springBoot.tutorial.restApi.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeServiceImplementation(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public Employee findById(int id) {
		return this.employeeDao.findById(id);
	}

	@Override
	@Transactional
	public Employee insert(Employee employee) {
		return employeeDao.insert(employee);
	}

	@Override
	@Transactional
	public void delete(int id) {
		employeeDao.delete(id);		
	}
	
}
