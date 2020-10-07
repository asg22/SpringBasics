package io.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
		
			session=factory.getCurrentSession();
			session.beginTransaction();
			Student s = session.get(Student.class, 3004);
			
			System.out.println(s.toString());
			
			session.delete(s);
			session.getTransaction().commit();
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			String hql = "delete from Student where id=3003";
			
			session.createQuery(hql).executeUpdate();
			
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
