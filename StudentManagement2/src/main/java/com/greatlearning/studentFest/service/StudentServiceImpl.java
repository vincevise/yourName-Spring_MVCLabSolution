package com.greatlearning.studentFest.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.jar.Attributes.Name;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.studentFest.controller.Student;
 

@Repository
public class StudentServiceImpl implements StudentService {

	private SessionFactory sessionFactory;
	private Session session;
	
	@Autowired
	public StudentServiceImpl(SessionFactory sessionFactory) {
		try {
			session = sessionFactory.getCurrentSession();
			
		}catch(HibernateException e) {
			session = sessionFactory.openSession();
		}
	}
	
	@Transactional
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		
		List<Student> students = session.createQuery("from Student").list();
		
		tx.commit();
		
		return students;
	}

	@Transactional
	public Student findById(int id) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		
		Student student = session.get(Student.class, id);
		
		tx.commit();
		return student;
	}

	@Transactional
	public void save(Student student) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		
		session.saveOrUpdate(student);
		
		tx.commit();
	}

	@Transactional
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		
		 Student student  = session.get(Student.class, id);
		 
		 session.delete(student);
		
		tx.commit();
	}

}
