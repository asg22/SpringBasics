package io.hibernate.demo.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			
			session.beginTransaction();
			
			String hql="from Student";
			
			List<Student> students = session.createQuery(hql).getResultList();
			
			System.out.println(students.get(1));
			
			String hql1="from Student where firstName='Akshay'";
			List<Student> students1 = session.createQuery(hql).getResultList();
			
			System.out.println(students1.get(2));
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
