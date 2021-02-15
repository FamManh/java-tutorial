package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
									
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create 3 student objects
			System.out.println("Creating new student object");
			Student tempStudent1 = new Student("Manh 1", "Pham", "manh@mail.ru");
			Student tempStudent2 = new Student("Manh 2", "Pham", "manh@mail.ru");
			Student tempStudent3 = new Student("Manh 3", "Pham", "manh@mail.ru");
			//start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// commit transaction
			session.getTransaction().commit();
		}finally {
			factory.close();
		}

	}
}
