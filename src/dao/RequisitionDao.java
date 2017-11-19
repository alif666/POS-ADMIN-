package dao;

import java.util.List;

import model.Recipe;
import model.Requisition;
import model.Unit;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RequisitionDao implements DaoInterface {
	Requisition requisition = new Requisition();
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	@Override
	public void insert(Object ob) {
        requisition = (Requisition)ob;
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(requisition);
        
        session.getTransaction().commit();
        session.close();
	
	}

	@Override
	public List view() {

		return null;
	}

	@Override
	public void delete(Object ob) {
		// TODO Auto-generated method stub
		
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
