package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
									
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 2;
			
//			//start a transaction
//			session.beginTransaction();
//			
//			// retrieve student based on the id: primary key
//			System.out.println("\nGetting student with id: " + studentId);
//			Student myStudent = session.get(Student.class, studentId);
//			
//			// delete the student
//			session.delete(myStudent);
//			
//			// commit the transaction
//			session.getTransaction().commit();
//			
			// NEW CODE
			session.beginTransaction();
			
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally {
			factory.close();
		}

	}

}
