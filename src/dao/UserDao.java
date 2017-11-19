package dao;

import java.util.List;

import javax.servlet.http.HttpSession;
import model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import dao.HibernateUtil;


public class UserDao implements DaoInterface {

	private boolean flag=false;
	HttpSession httpsession;
	Users user = new Users();
	public void insert(Object ob) {
		user = (Users)ob;
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();     
		session.save(user);	      
		session.getTransaction().commit();
		session.close();
		//sessionFactory.close();
	}
	public Object checkdao(int id)
	{

		Session session = sessionFactory.openSession();
		session.beginTransaction(); 
		user = (Users) session.get(Users.class,id);
		session.getTransaction().commit();
		//session.close();
		return user;
	}
	
    public void delete(Object ob)
    {
        
    	user = (Users)ob;

		Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
        //sessionFactory.close();
        
    }
	public List view(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query= session.createQuery("FROM Users");
		List<Users> users = query.list();
		session.getTransaction().commit();
		session.close();
		return users;
	}
	
	public void update(Object ob) {
        user = (Users)ob;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
	}




	public boolean validate(String name,String password){

		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query= session.createQuery("SELECT u FROM Users u WHERE u.userName='"+name+"'and u.userPassword='"+password+"'");
		List<Users> user = query.list();
		if(!user.isEmpty()){
			flag=true;
		}
		session.getTransaction().commit();
		session.close();
		return flag;		 
	}
	
	public Users getUser(String name,String password){

		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query= session.createQuery("SELECT u FROM Users u WHERE u.userName='"+name+"'and u.userPassword='"+password+"'");
		List<Users> user = query.list();

		session.getTransaction().commit();
		session.close();
		return user.get(0);		 
	}


}
