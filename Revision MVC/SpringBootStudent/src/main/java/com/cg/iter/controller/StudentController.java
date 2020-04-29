package com.cg.iter.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.enity.Address;
import com.cg.iter.enity.Student;
import com.cg.iter.service.StudentService;

@RestController
public class StudentController {

	private static final Logger Log = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	StudentService studentService;
	
	
	
	@GetMapping(value = "/student",produces = "application/json")
	public ResponseEntity<List<Student>> getAllStudent()
	{
		List<Student> s = studentService.findAllStudents();
        ResponseEntity<List<Student>> responseEntity = new ResponseEntity(s, HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping(value = "/student/find/{id}",produces = "application/json")
	public ResponseEntity<Student> findStudent(@PathVariable int id)
	{
		Student s = studentService.findStudentById(id);
        ResponseEntity<Student> responseEntity = new ResponseEntity(s, HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping(value = "/student/findbyname/{name}",produces = "application/json")
	public ResponseEntity<List<Student>> findStudentByName(@PathVariable String name)
	{
		List<Student> s = studentService.findStudentByName(name);
        ResponseEntity<List<Student>> responseEntity = new ResponseEntity(s, HttpStatus.OK);
		return responseEntity;
	}
	@PostMapping(value = "/student")
	public void addStudent(@RequestBody Student student)
	{
		studentService.create(student);
  
	}
	
	@PutMapping(value = "/student")
	public void updateStudent(@RequestBody Student student)
	{
		studentService.updateStudent(student);
	}
	
	@DeleteMapping(value = "/student/delete/{id}")
	public void deleteStudent(@PathVariable int id){
		studentService.deleteStudent(id);
	}
	
	@PostConstruct 
	public void asd() {
		Address addr = new Address(1,"Name","city");
		Student stud = new Student(1,"Sashi",1212121212,"JAVA",addr);
		studentService.create(stud);
	}
	
} 
