package com.api01.dao;

import com.api01.bean.User;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserDao {
	@Transactional
	public int addUser(User u);
}
