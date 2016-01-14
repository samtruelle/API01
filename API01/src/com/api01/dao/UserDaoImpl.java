package com.api01.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.api01.bean.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	@Override
	public int addUser(User u) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(u);
		tx.commit();
		Serializable id = session.getIdentifier(u);
		session.close();
		return (Integer) id;
	}

	@Transactional
	@Override
	public int updateUser(User u) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(u);
		tx.commit();
		Serializable id = session.getIdentifier(u);
		session.close();
		return (Integer) id;
	}

	@Transactional
	@Override
	public void removerUser(User u) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(u);
		tx.commit();
		session.close();
	}

	@Transactional
	@Override
	public User getUserById(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user = null;
		try {
			user = (User) session.get(User.class, id);
			Hibernate.initialize(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return user;
	}
	
	@Transactional
	@Override
	public User getUserByMail(String mail) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		User user = null;
		Criteria criteria = null;
		try {
			criteria = session.createCriteria(User.class);  
			user = (User) criteria.add(Restrictions.eq("email", mail)).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return user;
	}

	@Transactional
	@Override
	public List<User> getUsers() {
		//Session session = sessionFactory.openSession();
		//Transaction tx = session.beginTransaction();

		// TODO Auto-generated method stub
		return null;
	}
}
