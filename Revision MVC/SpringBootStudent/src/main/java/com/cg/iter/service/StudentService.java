package com.cg.iter.service;

import java.util.List;

import com.cg.iter.enity.Student;


public interface StudentService {

	boolean create(Student stud);
	Student findStudentById(int id);
	boolean updateStudent(Student id);
	void deleteStudent(int id);
	List<Student> findStudentByName(String name);
	List<Student> findAllStudents();
	

	

}