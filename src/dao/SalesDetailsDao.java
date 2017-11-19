/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

import model.SalesDetails;
import model.SalesInfo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Enamul Karim
 */
public class SalesDetailsDao implements DaoInterface{

    SalesDetails salesDetails=new SalesDetails();
    @Override
    public void insert(Object ob) {
        salesDetails = (SalesDetails)ob;

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(salesDetails);
        
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List view() {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Query query = session.createQuery("FROM SalesDetails");   
        List<SalesDetails> salesDetailsLists = query.list();
        session.getTransaction().commit();
        session.close();
        
        return salesDetailsLists;
        }

    @Override
    public void delete(Object ob) {
        salesDetails = (SalesDetails)ob;

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(salesDetails);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Object checkdao(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<SalesDetails> getListFromSameSession(long id){

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query= (Query) session.createQuery("SELECT u FROM SalesDetails u WHERE u.salesInfo.sessionId='"+id+"'");
		List<SalesDetails> sales_list = query.list();

                
                
		session.getTransaction().commit();
		session.close();
                
                return sales_list;
        
    }
    

}
