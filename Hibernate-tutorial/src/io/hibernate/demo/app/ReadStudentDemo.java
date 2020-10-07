package io.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			Student stud = new Student("Akshay", "Gawade", "test@gamil.com");
			
			session.beginTransaction();
			
			int t = (int)session.save(stud);
			
			System.out.println("id generated is "+t);
			
			session.getTransaction().commit();
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			Student s = session.get(Student.class, t);
			
			System.out.println(s.toString());
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
