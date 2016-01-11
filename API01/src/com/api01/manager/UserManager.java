package com.api01.manager;

import com.api01.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.transaction.Transactional;

public class UserManager {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public void addUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
		int id = (int) session.getIdentifier(user);
		System.out.println(id);
		session.close();
	}
}
