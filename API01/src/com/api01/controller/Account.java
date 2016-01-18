package com.api01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.api01.bean.User;
import com.api01.dao.*;

@Controller
public class Account {
	
	@Autowired
	UserDaoImpl	userdaoimpl; 
		
	@RequestMapping("/viewAccount")
	public ModelAndView viewProfile(HttpServletRequest request){
		System.out.println((String)request.getSession().getAttribute("login"));
		User user = userdaoimpl.getUserByMail((String)request.getSession().getAttribute("login"));
		if(user == null){
			return new ModelAndView("redirect:/home");
		}else{			
			return new ModelAndView("viewAccount", "user", user);
		}
	}
	
	@RequestMapping(value = "/editAccount", method = RequestMethod.GET)	
	public ModelAndView editProfile(HttpServletRequest request){		
		User user = userdaoimpl.getUserByMail((String)request.getSession().getAttribute("login"));
		if(user == null){
			return new ModelAndView("redirect:/home", "message", "User doesn't exist");
		}else{			
			return new ModelAndView("editAccount", "command", user);
		}
	}
	
	@RequestMapping(value = "/editAccount", method = RequestMethod.POST)	
	public ModelAndView PersistEditProfile(HttpServletRequest request,@ModelAttribute("command")User user){				
		if(user == null){
			return new ModelAndView("redirect:/home","message","Edition succeded");
		}else{		
			userdaoimpl.updateUser(user);
			return new ModelAndView("redirect:/viewAccount");
		}
	}
}
