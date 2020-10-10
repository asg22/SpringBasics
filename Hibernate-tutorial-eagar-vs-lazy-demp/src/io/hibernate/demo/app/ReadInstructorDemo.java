package io.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.hibernate.demo.entity.Course;
import io.hibernate.demo.entity.Instructor;
import io.hibernate.demo.entity.InstructorDetail;
import io.hibernate.demo.entity.Student;

public class ReadInstructorDemo {

	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			session.beginTransaction();
			
			Instructor insDetails = session.get(Instructor.class, 1);
			
			System.out.println(insDetails);
			System.out.println(insDetails.getCourses().get(0));
			//System.out.println(insDetails.getCourses().get(1));
			
			session.getTransaction().commit();
		session.close();
		System.out.println(insDetails.getCourses());	
			
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
			factory.close();
		}
	}
}
