package io.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.hibernate.demo.entity.Course;
import io.hibernate.demo.entity.Instructor;
import io.hibernate.demo.entity.InstructorDetail;
import io.hibernate.demo.entity.Review;
import io.hibernate.demo.entity.Student;

public class CreateCoursesAndStudentsDemo {

	
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
			
			Course course = new Course("Spring Boot");
			
			session.save(course);
			
			// stud = new Student("Akshay", "Gawade", "test@test.com");
			//Student stud1 = new Student("Akshay", "Gawade", "test@gmail.com");
			Student stud = session.get(Student.class, 1);
			
			course.addStudents(stud);
			//course.addStudents(stud);
			//course.addStudents(stud1);
			
			session.save(stud);
			//session.save(stud1);
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
