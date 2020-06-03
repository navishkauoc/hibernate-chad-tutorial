package com.navishka.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.navishka.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		//Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {
			//Create a student object
			Student tempStudent = new Student("Paul", "Wall", "paul@gmail.com");
			
			//Start transaction
			session.beginTransaction();
			
			//Save the student
			session.save(tempStudent);
			
			//Commit the transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
		
	}

}
