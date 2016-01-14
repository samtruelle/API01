package com.api01.controller;

import java.util.Date;


import com.api01.dao.UserDaoImpl;
import com.api01.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;  


@Controller
public class Home {
	@Autowired
	UserDaoImpl userdaoimpl;
	
	String message = "Welcome to your 1st Maven Spring project !";

	@RequestMapping("/hello")
	public ModelAndView showMessage() {		
		System.out.println("from controller");
		Date date = new Date();
		User u = new User("hello","mail","Steve", "BUNLON", "adresse", 2,  date, 1, 1);
		User u2 = new User("hello","email","Steve", "BUNLON", "adresse", 2,  date, 1, 1);

		System.out.println(userdaoimpl.getUserById(userdaoimpl.addUser(u)).getFirstName());
		 
		userdaoimpl.addUser(u2);
		
		userdaoimpl.removerUser(u);
		u2.setFirstName("ca marche");
		userdaoimpl.updateUser(u2);
		
		System.out.println(userdaoimpl.getUserByMail("email").getFirstName());
		
		return new ModelAndView("hello", "message", message);
	}
}

