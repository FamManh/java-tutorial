package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
									
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			// get the instructor detail object
			int theId= 3;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			// print the instructor detail
			System.out.println("Temp instructor detail: " + tempInstructorDetail);
			
			// print the associated instructor
			if(tempInstructorDetail != null) {
				System.out.println("Instructor: "+ tempInstructorDetail.getInstructor());
			}
			
			// now let's delete the instructor detail
			System.out.println("Deleting tempInstructorDetail: "+ tempInstructorDetail);
			
			// remove the associated object reference
			// break bi-directional link
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			
			session.delete(tempInstructorDetail);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			// handle connection leak issue
			session.close();
			factory.close();
		}

	}

}
