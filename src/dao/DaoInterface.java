package dao;

import java.util.List;

import org.hibernate.SessionFactory;



interface DaoInterface {
   public void insert(Object ob); 
   public List view();
   public void delete(Object ob);
   public Object checkdao(int id);
   public void update(Object ob);
   static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
  

}
