package com.navishka.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.navishka.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		//Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {
			//Create three student objects
			System.out.println("Creating 3 student objects...");
			Student tempStudent1 = new Student("Peter", "Drinker", "peter@gmail.com");
			Student tempStudent2 = new Student("Mike", "Hansen", "mike@gmail.com");
			Student tempStudent3 = new Student("Jake", "Gillen", "jake@gmail.com");
			
			//Start transaction
			session.beginTransaction();
			
			//Save the student
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			//Commit the transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

}
