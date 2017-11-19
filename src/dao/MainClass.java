package dao;

import model.IngredientsCategory;
import model.Unit;
import model.UserType;
import model.Users;
import controller.user.EncryptPassword;

public class MainClass {
	
	public static void main(String args[])
	{
		//Initially run this to set basics
		UserTypeDao userTypeDao = new UserTypeDao();
		UserType userType1 = new UserType();
		userType1.setTypeName("Waiter");
		userTypeDao.insert(userType1);
		
		UserType userType2 = new UserType();
		userType2.setTypeName("Cashier");
		userTypeDao.insert(userType2);
		
		UserType userType3 = new UserType();
		userType3.setTypeName("Kitchen Manager");
		userTypeDao.insert(userType3);
		
		UserType userType4 = new UserType();
		userType4.setTypeName("Purchase Boy");
		userTypeDao.insert(userType4);
		
		UserType userType5 = new UserType();
		userType5.setTypeName("Super Admin");
		userTypeDao.insert(userType5);
		
		
		Users userModel = new Users();
		userModel.setUserEmail("Enamul@yahoo.com");
		userModel.setUserName("Enamul");
		EncryptPassword e = new EncryptPassword();
		userModel.setUserPassword(e.encrypt("123"));
		userModel.setUserImage("style/images/kazi.jpg");
		userModel.setUserType(userType5);
		
		UserDao userDao = new UserDao();
		userDao.insert(userModel);
		
		
		Unit unit = new Unit();
		UnitDao unitDao = new UnitDao();
		
		unit.setUnitName("kg");
		unitDao.insert(unit);
		
		Unit unit1 = new Unit();
		unit1.setUnitName("gms");
		unitDao.insert(unit1);
		
		Unit unit2 = new Unit();
		unit2.setUnitName("Litre");
		unitDao.insert(unit2);
		
		Unit unit3 = new Unit();
		unit3.setUnitName("ml");
		unitDao.insert(unit3);
		
		Unit unit4 = new Unit();
		unit4.setUnitName("pc");
		unitDao.insert(unit4);
		
		
		IngredientsCategoryDao categoryDao = new IngredientsCategoryDao();
		
		IngredientsCategory category = new IngredientsCategory();
		category.setIngredientsCategoryName("Ready Stock");
		categoryDao.insert(category);
		
		IngredientsCategory category1 = new IngredientsCategory();
		category1.setIngredientsCategoryName("Lead Time");
		categoryDao.insert(category1);
		
		IngredientsCategory category2 = new IngredientsCategory();
		category2.setIngredientsCategoryName("Perishable");
		categoryDao.insert(category2);
		
		IngredientsCategory category3 = new IngredientsCategory();
		category3.setIngredientsCategoryName("Auxiliary");
		categoryDao.insert(category3);
		
		IngredientsCategory category4 = new IngredientsCategory();
		category4.setIngredientsCategoryName("Others");
		
		
        
	}

}
