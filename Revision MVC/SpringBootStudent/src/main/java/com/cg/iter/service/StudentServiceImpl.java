package com.cg.iter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cg.iter.dao.StudentDao;
import com.cg.iter.enity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
    private StudentDao studDao;
	@Override
	public boolean create(Student stud) {
		return studDao.save(stud) != null;
	}
	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		return studDao.getOne(id);
	}
	@Override
	public boolean updateStudent(Student stud) {
		// TODO Auto-generated method stub
		return studDao.save(stud) != null;
	}
	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		studDao.deleteById(id);
	}
	@Override
	public List<Student> findStudentByName(String name) {
		// TODO Auto-generated method stub
		return studDao.findByName(name);
	}
	@Override
	public List<Student> findAllStudents() {
		// TODO Auto-generated method stub
		return studDao.findAll();
	}
	
   
}