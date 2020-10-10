package io.hibernate.demo.app;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import io.hibernate.demo.entity.Course;
import io.hibernate.demo.entity.Instructor;
import io.hibernate.demo.entity.InstructorDetail;
import io.hibernate.demo.entity.Student;

public class FetchJoinDemo {

	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			session.beginTransaction();
			
			//Instructor insDetails = session.get(Instructor.class, 1);
			
			Query<Instructor> query = session.createQuery("select i from Instructor i join fetch i.courses "
					+ "where i.id=:theInstructorId",Instructor.class);
			
			query.setParameter("theInstructorId", 1);
			
			Instructor ins = query.getSingleResult();
			System.out.println(ins);
			
			session.getTransaction().commit();
		session.close();	
			System.out.println(ins.getCourses());
				
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
