package io.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.hibernate.demo.entity.Instructor;
import io.hibernate.demo.entity.InstructorDetail;
import io.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			//inserts instructordetails first then instructor
			InstructorDetail insDetail= new InstructorDetail("Code with AGS", "Coding");
			
			Instructor ins = new Instructor("Akshay", "Gawade", "test@test.com");
			
			ins.setInstructorDetail(insDetail);
			session.beginTransaction();

			session.save(ins);
			
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
