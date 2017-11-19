package dao;

import java.util.List;

import model.ReqIngredients;
import model.Requisition;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ReqIngredientsDao implements DaoInterface{
	

	ReqIngredients reqIngredients = new ReqIngredients();
	
	public void insert(Object ob) {
		reqIngredients = (ReqIngredients)ob;
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(reqIngredients);
        
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
