package io.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.hibernate.demo.entity.Course;
import io.hibernate.demo.entity.Instructor;
import io.hibernate.demo.entity.InstructorDetail;
import io.hibernate.demo.entity.Student;

public class CreateCoursesDemo {

	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			
			
		
			Course course = new Course("Java");
			Course course1 = new Course("PHP");
			Course course2 = new Course("Python");
			
		
			
			
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, 1);
			instructor.add(course);
			instructor.add(course1);
			instructor.add(course2);
			session.save(course);
			session.save(course1);
			session.save(course2);
			
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
