package com.cg.iter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cg.iter.bean.Student;
import com.cg.iter.dao.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
    private StudentDao studDao;
	@Override
	public boolean create(Student stud) {
		return studDao.create(stud);
	}
	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		return studDao.findStudentById(id);
	}
	@Override
	public boolean updateStudent(Student stud) {
		// TODO Auto-generated method stub
		return studDao.updateStudent(stud);
	}
	@Override
	public boolean deleteStudent(int id) {
		// TODO Auto-generated method stub
		return studDao.deleteStudent(id);
	}
	@Override
	public Student findStudentByName(String name) {
		// TODO Auto-generated method stub
		return studDao.findStudentByName(name);
	}
	@Override
	public List<Student> findAllStudents() {
		// TODO Auto-generated method stub
		return studDao.findAllStudents();
	}
	
   
}
