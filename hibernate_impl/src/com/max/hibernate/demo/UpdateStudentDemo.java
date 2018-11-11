package com.max.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.max.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studenId = 1;
	
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
		
			// retrieve student based on id : primary key
		
			System.out.println("getting student with id: "+ studenId);
			Student myStudent = session.get(Student.class, studenId);
			
			System.out.println("Updating student");
			myStudent.setFirstName("Scooby");
			
			// commit the transaction
			session.getTransaction().commit();
			
			
			// new code
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for all students
			System.out.println("Update email for all students");
			
			session.createQuery("update Student set email='test@gmail.com'")
			.executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done.");
		} finally {
			factory.close();
		}
	}

}
