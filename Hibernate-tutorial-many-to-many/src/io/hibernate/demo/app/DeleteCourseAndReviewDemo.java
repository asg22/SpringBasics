package io.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.hibernate.demo.entity.Course;
import io.hibernate.demo.entity.Instructor;
import io.hibernate.demo.entity.InstructorDetail;
import io.hibernate.demo.entity.Review;
import io.hibernate.demo.entity.Student;

public class DeleteCourseAndReviewDemo {

	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			//deletes instructor first then instructor details
			session.beginTransaction();

			Course course = session.get(Course.class, 12);

			
			session.delete(course);
			
			session.getTransaction().commit();
				
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
