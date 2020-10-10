package io.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.hibernate.demo.entity.Instructor;
import io.hibernate.demo.entity.InstructorDetail;
import io.hibernate.demo.entity.Student;

public class ReadInstructorDemo {

	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			session.beginTransaction();
			
			InstructorDetail insDetails = session.get(InstructorDetail.class, 2);
			
			System.out.println(insDetails);
			
			System.out.println(insDetails.getInstructor());
			
			session.getTransaction().commit();
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			factory.close();
		}
	}
}
