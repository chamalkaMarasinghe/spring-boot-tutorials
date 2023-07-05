package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.StudentDAO;
import com.example.demo.dao.StudentDaoImplementation;
import com.example.demo.entity.Student;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDao) {
		return runner -> {
			deleteStudentBasedOnEmail(studentDao, "fake");
		};
	}
	
	private void creatAndSaveStudent(StudentDAO studentDao) {
		Student myStudent = new Student("Chamal", "Marasinghe", "gmail.com");
		studentDao.save(myStudent);
		studentDao.save(new Student("fake2-fn", "fake2-ln", "fake2-email"));
		studentDao.save(new Student("fake3-fn", "fake3-ln", "fake3-email"));
		studentDao.save(new Student("fake4-fn", "fake4-ln", "fake4-email"));
		studentDao.save(new Student("fake5-fn", "fake5-ln", "fake5-email"));
		studentDao.save(new Student("fake6-fn", "fake6-ln", "fake6-email"));
		studentDao.save(new Student("fake7-fn", "fake7-ln", "fake7-email"));
	}
	
	private void readAllStudent(StudentDAO studentDao) {
		List<Student> stuList = studentDao.findAll();
		for(Student tempStudent : stuList) {
			System.out.println(tempStudent);
		}
	}
	
	private void deleteOneStudent(StudentDAO studentDao, int id) {
		studentDao.deleteOne(id);
	}

	private void deleteStudentBasedOnEmail(StudentDAO studentDao, String pattern) {
		studentDao.deleteMultiple(pattern);
	}
}












