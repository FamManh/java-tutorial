package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;


public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
									
		// create session
		Session session = factory.getCurrentSession(); 
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			// create a course 
			Course tempCourse = new Course("Pacman  How to score one million points");
			
			// add some Students
			Student tempStudent1 = new Student("Manh", "Pham", "manh@mail.ru");
			Student tempStudent2 = new Student("Hoa", "Pham", "hoa@mail.ru");
			Student tempStudent3 = new Student("Linh", "Pham", "linh@mail.ru");
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			tempCourse.addStudent(tempStudent3);
			
			// save the students 
			System.out.println("Saving students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			System.out.println("Saved students: " + tempCourse.getStudents());
			
			// save the course ... and leverage the cascade all ))
			System.out.println("Saving the course");
			System.out.println(tempCourse);
			session.save(tempCourse);
			
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
