package com.api01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.api01.dao.UserDaoImpl;

@Controller
public class Admin {
	
	@Autowired
	UserDaoImpl	userdaoimpl;
	
	@RequestMapping("/adminUsers")
	public ModelAndView showUsers() {
		userdaoimpl.getUsers();
		return new ModelAndView("adminUsers", "users", userdaoimpl.getUsers());
	}
	
	@RequestMapping("/AdminUsersDelete")
	public ModelAndView deleteUser(HttpServletRequest request, @RequestParam("userId") String userId){
		//userdaoimpl.getUserById()
		return new ModelAndView("adminUsers");
	}
}
