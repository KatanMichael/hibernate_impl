package com.max.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.max.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {

			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList(); // all student objects
			
			
			// display the students
			displayStudents(theStudents);
			
			// query students: lastName 'lee'
			theStudents = session.createQuery("from Student s where s.lastName='Lee'").getResultList();
			
			// display the students with lastName 'lee'
			
			System.out.println("students who has the lastName 'lee'");
			displayStudents(theStudents);
			
			
			// query students: lastName='lee' OR firstName='Jacky'
			theStudents = session.createQuery("from Student s where" 
					+" s.lastName='Lee' OR s.firstName='Jacky'").getResultList();
			
			// display the students
			System.out.println("query students: lastName='lee' OR firstName='Jacky'");
			displayStudents(theStudents);
			
			// query students where email LIKE '%hit.ac.il
			theStudents = session.createQuery("from Student s where"
					+" s.email LIKE '%hit.ac.il'").getResultList();
			
			// display the students
			System.out.println("query students where email LIKE '%hit.ac.il'");
			displayStudents(theStudents);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done.");
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
		System.out.println("\n");
	}

}
