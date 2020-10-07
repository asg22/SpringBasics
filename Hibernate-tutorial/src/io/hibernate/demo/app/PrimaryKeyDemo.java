package io.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			Student stud = new Student("Akshay", "Gawade", "test@test.com");
			Student stud1 = new Student("Akshay", "Gawade2", "test@testt.com");
			Student stud2= new Student("Akshay", "Gawade3", "test@tst.com");
			
			session.beginTransaction();
			
			int t = (int)session.save(stud);
			int t1 = (int)session.save(stud1);
			int t2= (int)session.save(stud2);
			System.out.println("id generated is "+t);
			
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
