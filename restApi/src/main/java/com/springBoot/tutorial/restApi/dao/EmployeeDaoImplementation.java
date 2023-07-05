package com.springBoot.tutorial.restApi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springBoot.tutorial.restApi.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDaoImplementation implements EmployeeDao{
	
	private EntityManager entityManger;
	
	@Autowired
	public EmployeeDaoImplementation(EntityManager theEntityManager) {
		this.entityManger = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> empLisT = entityManger.createQuery("FROM Employee", Employee.class);
		return empLisT.getResultList();
	}

	@Override
	public Employee findById(int id) {
		return entityManger.find(Employee.class, id);
	}

	@Override
	public Employee insert(Employee obj) {
		Employee employee = entityManger.merge(obj);
		return employee;
	}

	@Override
	public void delete(int id) {
		Employee employee = entityManger.find(Employee.class, id);
		entityManger.remove(employee);
	}

}
