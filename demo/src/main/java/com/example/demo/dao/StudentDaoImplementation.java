package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDaoImplementation implements StudentDAO{

	private EntityManager entitymanager;
	
	@Autowired
	public StudentDaoImplementation(EntityManager entitymanager) {
		this.entitymanager = entitymanager;
	}
	
	@Override
	@Transactional
	public void save(Student theStudent) {
		this.entitymanager.persist(theStudent);
	}

	@Override
	public Student findById(int id) {
		return entitymanager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> theQuery = entitymanager.createQuery("FROM Student", Student.class);
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void deleteOne(int id) {
		Student student = entitymanager.find(Student.class, id);
		entitymanager.remove(student);
		
	}

	@Override
	@Transactional
	public void deleteMultiple(String pattern) {
		entitymanager.createQuery("DELETE from Student WHERE email LIKE '%" + pattern + "%'").executeUpdate();
	}

}
