/**
 * 
 */
package com.api01.manager;
import java.sql.Date;
import com.javadude.annotation.Bean;
import com.javadude.annotation.Default;


import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.api01.bean.User;

/**
 * @author samuel
 *
 */
public class UserManager {
	   private static SessionFactory factory; 
	   
	   /**
	    * METHOD to add user
	    * @param lastName
	    * @param firstName
	    * @param mail
	    * @param pwd
	    * @param adr
	    * @param telephone
	    * @param creation
	    * @param account
	    * @return
	    */
	   public Integer addUser(String lastName, 
			   				  String firstName, 
			   				  String mail, 
			   				  String pwd, 
			   				  String adr, 
			   				  String telephone, 
			   				  Date creation,
			   				  String account){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      Integer userID = null;    
		      try{
			         tx = session.beginTransaction();
			         User user= new User();
			         user.setFirstName(firstName);
			         user.setLastName(lastName);
			         user.setEmail(mail);
			         //pwd should be at least hached
			         user.setPassword(pwd);
			         user.setAdresse(adr);
			         user.setTelephone(telephone);
			         user.setCreationDate(creation);
			         user.setAccount(account);
			         userID = (Integer) session.save(user); 
			         tx.commit();
			      }catch (HibernateException e) {
			         if (tx!=null) tx.rollback();
			         e.printStackTrace(); 
			      }finally {
			         session.close(); 
			      }
			      return userID;
			   }
	   
	   /**
	    * Retrieve the User corresponding to the given ID and update it
	    * @param userID 
	    * @param lastName
	    * @param firstName
	    * @param mail
	    * @param pwd
	    * @param adr
	    * @param telephone
	    * @param account
	    * @return
	    */
	   	public void updateUser(Integer uID,
	   							  String lastName, 
				   				  String firstName, 
				   				  String mail, 
				   				  String pwd, 
				   				  String adr, 
				   				  String telephone,
				   				  String account){
	        Session session = factory.openSession();
	        Transaction tx = null;
	        try{
	           tx = session.beginTransaction();
	           User user = 
	                      (User)session.get(User.class, uID); 
	             user.setFirstName(firstName);
		         user.setLastName(lastName);
		         user.setEmail(mail);
		         //pwd should be at least hached
		         user.setPassword(pwd);
		         user.setAdresse(adr);
		         user.setTelephone(telephone);
		         user.setAccount(account);
	  		 session.update(user); 
	           tx.commit();
	        }catch (HibernateException e) {
	           if (tx!=null) tx.rollback();
	           e.printStackTrace(); 
	        }finally {
	           session.close(); 
	        }
	   	}
	   	
	    /**
	     * Method to DELETE a user from the records 
	     * @param uID 
	     */
	    public void deleteUser(Integer uID){
	       Session session = factory.openSession();
	       Transaction tx = null;
	       try{
	          tx = session.beginTransaction();
	          User user = 
	                    (User)session.get(User.class, uID); 
	          session.delete(user); 
	          tx.commit();
	       }catch (HibernateException e) {
	          if (tx!=null) tx.rollback();
	          e.printStackTrace(); 
	       }finally {
	          session.close(); 
	       }
	    }
	   }
