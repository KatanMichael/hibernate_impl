package com.max.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.max.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save save object			
			// create 3 student objects
			System.out.println("creating 3 student objects");
			Student tempStudent1 = new Student("Chuck","Norris","norris@gmail.com");
			Student tempStudent2 = new Student("Jacky","Chan","chan@gmail.com");
			Student tempStudent3 = new Student("Bruce","Lee","lee@gmail.com");

			// start a transaction
			session.beginTransaction();
			// save the student object
			System.out.println("saving the students");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done.");
		} finally {
			factory.close();
		}
		
		
	}

	}


