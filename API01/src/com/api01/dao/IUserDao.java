package com.api01.dao;
import com.api01.bean.User;

import java.util.List;

import javax.transaction.Transactional;

public interface IUserDao {
	@Transactional
	int addUser(User u);
	
	@Transactional
	int updateUser(User u);
	
	@Transactional
	void removerUser(User u);
	
	@Transactional
	User getUserById(Integer id);
	
	@Transactional
	List<User> getUsers();

	@Transactional
	User getUserByMail(String mail);
	
}
