package io.hibernate.demo.app;

import java.util.List;

import javax.persistence.FetchType;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.FetchStyle;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane.ScalableIconUIResource;

import io.hibernate.demo.entity.Course;
import io.hibernate.demo.entity.Instructor;
import io.hibernate.demo.entity.InstructorDetail;
import io.hibernate.demo.entity.Review;

public class ReadInstructorDemo {

	
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
			
			/*Instructor insDetails = session.get(Instructor.class, 1);
			
			System.out.println(insDetails);
			
			System.out.println(insDetails.getCourses().get(0));
			System.out.println(insDetails.getCourses().get(1));*/
			
			Criteria c=session.createCriteria(Instructor.class,"ins");
			//c.createAlias("ins.instructorDetail", "instructorDetail");
			Criteria c1 =c.createCriteria("instructorDetail");
			c1.add(Restrictions.eq("id", 1));
			//c.setProjection(Projections.property("firstName"));
			//ProjectionList p = Projections.projectionList();
			//p.add(Projections.property("firstName"));
			//p.add(Projections.property("lastName"));
			//c.setProjection(p);
			//return type of restrictions is criterian
			//List<Instructor> ins = c.list();
			Instructor ins =(Instructor)c1.uniqueResult();
			System.out.println(ins);
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
