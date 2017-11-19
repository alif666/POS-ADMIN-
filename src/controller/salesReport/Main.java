package controller.salesReport;

import java.util.List;

import org.hibernate.SessionFactory;

import java.util.Iterator;
import java.util.List;

import model.SalesDetails;
import model.SalesInfo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fasterxml.classmate.AnnotationConfiguration;

import dao.HibernateUtil;


public class Main {

	public static void main(String args[])
	{
		  SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	      Session session = sessionFactory.openSession();
	      session.beginTransaction();
		  String SQL_QUERY = "SELECT pr.recipeName,SUM(pr.quantity) FROM ProductReport pr group by recipeName";
		  Query query = session.createQuery(SQL_QUERY);
		    
		  for(Iterator it=query.iterate();it.hasNext();)
		  {
		   long row =   (long)it.next();
		   System.out.print("MAX QUANTITY: " + row);
		  }
		  session.getTransaction().commit();
		  session.close();
		 
		
	}
}
