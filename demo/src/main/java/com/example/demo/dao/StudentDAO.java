package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentDAO {
	public void save(Student theStudent);
	public Student findById(int id);
	public List<Student> findAll();
	public void deleteOne(int id);
	public void deleteMultiple(String pattern);
}
