package io.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.hibernate.demo.entity.Course;
import io.hibernate.demo.entity.Instructor;
import io.hibernate.demo.entity.InstructorDetail;
import io.hibernate.demo.entity.Review;
import io.hibernate.demo.entity.Student;

public class CreateCoursesAndReviewsDemo {

	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{	
			session.beginTransaction();
			Instructor ins = session.get(Instructor.class, 1);
			Course course = new Course("JAVA");
			ins.add(course);
			course.addReview(new Review("Goot Explaination"));
			course.addReview(new Review("Great Course"));	
			
			session.save(course);
			
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
