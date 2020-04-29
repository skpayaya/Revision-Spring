package com.cg.iter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cg.iter.bean.Student;
//import com.cg.iter.repository.AddressRepository;
//import com.cg.iter.repository.StudentRepository;
import com.cg.iter.util.JpaUtil;

@Repository
public class StudentDaoImpl implements StudentDao {
	private EntityManager em = JpaUtil.getEntityManager();

	@Override
	public boolean create(Student stud) {
		try {
			em.getTransaction().begin();
			em.persist(stud);
			em.getTransaction().commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Student findStudentById(int id) {
		try {
			Student res = null;
			res = em.find(Student.class, id);
			return res;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public boolean updateStudent(Student student) {
		em.getTransaction().begin();
		em.merge(student);
		em.getTransaction().commit();
		return true;
	}

	@Override
	public boolean deleteStudent(int id) {
		em.getTransaction().begin();
		em.remove(findStudentById(id));
		em.getTransaction().commit();
		return true;
	}

	@Override
	public Student findStudentByName(String name) {
		try {
			Query query = em.createQuery("select stud from Student stud where stud.name=:name");
			query.setParameter("name",name);
			return (Student) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

	@Override
	public List<Student> findAllStudents() {
		String query="select stud from Student stud";
		TypedQuery<Student> tq = em.createQuery(query, Student.class);
		return tq.getResultList();
	}



}
