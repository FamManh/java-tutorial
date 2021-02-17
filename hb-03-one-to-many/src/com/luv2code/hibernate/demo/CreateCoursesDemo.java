package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class CreateCoursesDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
									
		// create session
		Session session = factory.getCurrentSession(); 
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			// get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			// create some courses
			Course course1 = new Course("course 1");
			Course course2 = new Course("course 2");
			Course course3 = new Course("course 3");
			Course course4 = new Course("course 4");
			
			// add course to instructor
			tempInstructor.add(course1);
			tempInstructor.add(course2);
			tempInstructor.add(course3);
			tempInstructor.add(course4);
			
			// save the courses
			session.save(course1);
			session.save(course2);
			session.save(course3);
			session.save(course4);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		}finally {
			
			// add clean up code
			session.close();
			factory.close();
		}

	}

}
