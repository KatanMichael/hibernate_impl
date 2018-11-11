package com.max.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.max.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
//			// delete the student 1
//			// method 1
//			System.out.println("deleting student" +myStudent);
//			session.delete(myStudent);
			
			// delete the student 2
			// method 2
			System.out.println("deleting student" +myStudent+1);
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			
		
			System.out.println("Done.");
		} finally {
			factory.close();
		}
	}

}
