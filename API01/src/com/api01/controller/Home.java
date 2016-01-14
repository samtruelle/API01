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
		userdaoimpl.addUser(u);
		return new ModelAndView("hello", "message", message);
	}
}

