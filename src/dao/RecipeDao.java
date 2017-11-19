package dao;

import java.util.List;

import model.Recipe;
import model.Unit;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RecipeDao implements DaoInterface {

	@Override
	public void insert(Object ob) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List view() {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Query query = session.createQuery("FROM Recipe");   
        List<Recipe> recipe= query.list();
        session.getTransaction().commit();
        session.close();
        
        return recipe;
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
