package com.navishka.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.navishka.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		//Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {
			//Start transaction
			session.beginTransaction();
			
			//Query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display students
			for(Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			}
			
			//Commit the transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
		
	}

}
