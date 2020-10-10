package io.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.hibernate.demo.entity.Course;
import io.hibernate.demo.entity.Instructor;
import io.hibernate.demo.entity.InstructorDetail;
import io.hibernate.demo.entity.Review;
import io.hibernate.demo.entity.Student;

public class DeleteCoursesAndStudentsDemo {

	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{	
			session.beginTransaction();
			//Course course = session.get(Course.class, 10);
	
			//System.out.println(course.getStudents());
			//session.delete(course);
			
			Student  stud = session.get(Student.class, 2);
			
			session.delete(stud);
			
			
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
