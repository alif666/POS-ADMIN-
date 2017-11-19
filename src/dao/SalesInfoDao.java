/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Iterator;
import java.util.List;

import model.SalesDetails;
import model.SalesInfo;
import model.YearlyDetails;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class SalesInfoDao implements DaoInterface{

  SalesInfo salesInfo=new SalesInfo();
    @Override
    public void insert(Object ob) {
        salesInfo = (SalesInfo)ob;

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        System.out.println("========================Sales info values are =-=====================================");
        System.out.println(salesInfo.getDate()+" is the date");
        System.out.println(salesInfo.getOrderStatus()+" is the sales status");
        System.out.println(salesInfo.getOrderType()+ " is the order type ");
        System.out.println(salesInfo.getSubTotal()+" is the subtotal");
        System.out.println(salesInfo.getTable().getId()+" is the id");
        System.out.println(salesInfo.getWaiterId().getUserName()+" is the waiter user name");
        
        
        session.save(salesInfo);
        
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List view() {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Query query = session.createQuery("FROM SalesInfo");   
        List<SalesInfo> salesInfoLists = query.list();
        session.getTransaction().commit();
        session.close();
        
        return salesInfoLists;
       
    }

    @Override
    public void delete(Object ob) {
        salesInfo = (SalesInfo)ob;

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(salesInfo);
        session.getTransaction().commit();
        session.close();
      
    }

    
    public Object checkDaoLong(long id) {
                System.out.println("the id that entered is "+id);

		Session session = sessionFactory.openSession();
		session.beginTransaction(); 
                Query query= (Query) session.createQuery("SELECT u FROM SalesInfo u WHERE u.sessionId='"+id+"'");
		List<SalesInfo> salesInfoList = query.list();
                salesInfoList = query.list(); 

                salesInfo =  salesInfoList.get(0);
         
                System.out.println(salesInfo.getSessionId()+"is the sales info id");
		session.getTransaction().commit();
		//session.close();
		return salesInfo;
     
    }

    @Override
    public void update(Object ob) {
        salesInfo = (SalesInfo)ob;

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(salesInfo);
        session.getTransaction().commit();
        session.close();
    
       
    }

    @Override
    public Object checkdao(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List getMonthDetails(String year){

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT SUM(si.orderTotal),SUM(si.subTotal),SUM(si.vat),substr(si.date, 6, 2)  FROM SalesInfo si WHERE si.date like '"+year+"%' and si.orderStatus='Paid' group by substr(si.date, 6, 2) order by substr(si.date, 6, 2) asc"); 
        List<YearlyDetails> yearlyDetails = query.list();
        session.getTransaction().commit();
        session.close();
        return yearlyDetails;
		
	}
    
	public List getCategoryWiseSales(String date){

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //select menucategory.menucategoryname as name,count(*) as number from menucategory inner join recipe on (menucategory.id=recipe.category_id) inner join salesdetails on (recipe.id=salesdetails.recipe_id) group by menucategory.menucategoryname
        Query query = session.createQuery("SELECT mc.menuCategoryName as name,SUM(sd.quantity) as number from SalesDetails sd inner join sd.recipe r inner join sd.salesInfo si inner join r.category mc where si.date='"+date+"' group by mc.menuCategoryName");

        List<Object[]> SalesDetailsLists = query.list();
        session.getTransaction().commit();
        session.close();
        return SalesDetailsLists;
		
	}
	public List getWeeklyTotalSales(String date1, String date2){
	     Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        //select menucategory.menucategoryname as name,count(*) as number from menucategory inner join recipe on (menucategory.id=recipe.category_id) inner join salesdetails on (recipe.id=salesdetails.recipe_id) group by menucategory.menucategoryname
	        Query query = session.createQuery("SELECT  SUM (si.orderTotal) as total,si.date  from SalesDetails sd inner join sd.salesInfo si group by si.date  having si.date between '"+date1+"' and '"+date2+"' order by si.date asc");

	        List<Object[]> SalesDetailsLists = query.list();
	        session.getTransaction().commit();
	        session.close();
	        return SalesDetailsLists;
	}
	
	public List getTodayList(String date){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Query query = session.createQuery("SELECT u FROM SalesInfo u WHERE u.date='"+date+"' and u.orderStatus='Paid'"); 
        List<SalesInfo> salesInfoLists = query.list();
        session.getTransaction().commit();
        session.close();
        
        return salesInfoLists;
		
	}
	public List getCustomList(String date1,String date2){

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Query query = session.createQuery("SELECT u FROM SalesInfo u WHERE u.date BETWEEN '"+date1+"'and '"+date2+"' and u.orderStatus='Paid'"); 
        List<SalesInfo> salesInfoLists = query.list();
        session.getTransaction().commit();
        session.close();
        
        return salesInfoLists;
		
	}
	
	public List getProductWiseList(String date){

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Query query = session.createQuery("SELECT r.name,SUM(sd.quantity) as sum,r.price from SalesDetails sd inner join sd.recipe r inner join sd.salesInfo si where si.date='"+date+"' and si.orderStatus='Paid' group by r.name,r.price order by SUM(sd.quantity) desc");

        List<Object[]> SalesDetailsLists = query.list();
        session.getTransaction().commit();
        session.close();
        
        return SalesDetailsLists;
		
	}
	
	public List getProductWiseListTop5(String date){

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Query query = session.createQuery("SELECT r.name,SUM(sd.quantity) as sum,r.price from SalesDetails sd inner join sd.recipe r inner join sd.salesInfo si where si.date='"+date+"' and si.orderStatus='Paid' group by r.name,r.price order by SUM(sd.quantity) desc");
        query.setMaxResults(5);
        List<Object[]> SalesDetailsLists = query.list();
        session.getTransaction().commit();
        session.close();
        
        return SalesDetailsLists;
		
	}
	public List getProductWiseList(String date1,String date2){

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Query query = session.createQuery("SELECT r.name,SUM(sd.quantity),r.price from SalesDetails sd inner join sd.recipe r inner join sd.salesInfo si where si.date between'"+date1+"' and '"+date2+"' and si.orderStatus='Paid' group by r.name,r.price order by SUM(sd.quantity) desc");

        List<Object[]> SalesDetailsLists = query.list();
        session.getTransaction().commit();
        session.close();
        
        return SalesDetailsLists;
		
	}
}
