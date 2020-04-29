package com.cg.iter.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.iter.enity.Student;


public interface StudentDao extends JpaRepository<Student, Integer> {

	
	public List<Student> findByName(String name);
	

}