package com.example.restApi.demoRestApi.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restApi.demoRestApi.customExceptions.StudentNotFound;
import com.example.restApi.demoRestApi.entity.Student;
import com.example.restApi.demoRestApi.exceptionResponses.StudentNotFoundResponse;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> stuList = new ArrayList<Student>();
	
	public StudentRestController() {
		this.stuList.add(new Student("fake-1-fn", "fake-1-ln", 10));
		this.stuList.add(new Student("fake-2-fn", "fake-2-ln", 12));
		this.stuList.add(new Student("fake-3-fn", "fake-3-ln", 13));
		this.stuList.add(new Student("fake-4-fn", "fake-4-ln", 14));
		this.stuList.add(new Student("fake-5-fn", "fake-5-ln", 15));
	}

	@GetMapping("/students")
	public List<Student> getStudent() {
		return this.stuList;
	}
	
	@GetMapping("/students/{index}")
	public Student getStudentByIndex(@PathVariable int index) {
		
		if(index >= this.stuList.size() || index < 0) {
			throw new StudentNotFound("Student not found at" + index + " !");
		}
		
		return this.stuList.get(index);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentNotFoundResponse> studentNotFoundHandler(StudentNotFound customException){
		
		StudentNotFoundResponse response = new StudentNotFoundResponse();
		
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setMsg(customException.getMessage());
		response.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
//	the exception handler that can be caught all types of exceptions
	@ExceptionHandler
	public ResponseEntity<StudentNotFoundResponse> studentNotFoundHandlerForAllTypes(Exception customException){
		
		StudentNotFoundResponse response = new StudentNotFoundResponse();
		
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setMsg(customException.getMessage());
		response.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}




















