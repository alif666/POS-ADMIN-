package dao;

import java.util.List;

import model.Tables;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TableDao implements DaoInterface{
    
	Tables tables = new Tables();
	@Override
	public void insert(Object ob) {
		   tables = (Tables)ob;

	        Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        
	        session.save(tables);
	        
	        session.getTransaction().commit();
	        session.close();
		
	}

	@Override
	public List view() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Object ob) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory;
		sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session;
		session = sessionFactory.openSession();
		
		session.beginTransaction();
		String stringQuery = "DELETE FROM Tables";
		Query query = session.createQuery(stringQuery);
		
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Object checkdao(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Object ob) {
		// TODO Auto-generated method stub
		
	}

}
