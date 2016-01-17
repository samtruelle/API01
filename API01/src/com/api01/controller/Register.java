package com.api01.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.api01.bean.User;
import com.api01.dao.*; 

@Controller
@RequestMapping("/register")
public class Register {
	 
	@Autowired
	UserDaoImpl userdaoimpl; 

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showMessage(Model model) {
		model.addAttribute("user", new User());
		return new ModelAndView("register", "command", new User());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView registration(HttpServletRequest request,@ModelAttribute("command")User user) {
		ModelAndView mav; 
		if(user != null){
			if(userdaoimpl.getUserByMail(user.getEmail()) != null){
				mav = new ModelAndView("register", "command", user);
				mav.addObject("message", "A user allready exists with the email given !");
				return  mav;
			}else{		
				user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
				java.util.Date d = new java.util.Date();
				user.setCreationDate(new java.sql.Date(d.getTime()));
				user.setAdmin(0);
				user.setAccount_blocked(1);
				userdaoimpl.addUser(user);
				request.getSession().setAttribute("admin",user.getAdmin());
				request.getSession().setAttribute("login",user.getEmail());
				request.getSession().setAttribute("first_name",user.getFirstName());
				request.getSession().setAttribute("last_name",user.getLastName());				
			}
		}
		return new ModelAndView("redirect:/home");
	}
}
