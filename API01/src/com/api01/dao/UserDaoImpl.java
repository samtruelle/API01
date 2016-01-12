package com.api01.dao;

import java.io.Serializable; 
import javax.transaction.Transactional;  
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.springframework.beans.factory.annotation.Autowired;

import com.api01.bean.User;

public class UserDaoImpl implements UserDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public int addUser(User u){
	 Session session = sessionFactory.openSession();  
	  Transaction tx = session.beginTransaction();  
	  session.saveOrUpdate(u);  
	  tx.commit();
	  Serializable id = session.getIdentifier(u);  
	  session.close();  
	  return (Integer) id;
	}
}
