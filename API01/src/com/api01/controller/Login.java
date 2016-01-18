package com.api01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.api01.bean.User;
import com.api01.dao.UserDaoImpl;

@Controller
@RequestMapping("/login")
public class Login {

	@Autowired
	UserDaoImpl userdaoimpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showMessage(Model model) {
		model.addAttribute("user", new User());
		return new ModelAndView("login");
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView registration(HttpServletRequest request, @RequestParam("email") String email, @RequestParam("password") String password) {		
		System.out.println(password);
		System.out.println(email);
		User u = userdaoimpl.getUserByMail(email);
		ModelAndView mav;
		if(u == null){
			mav = new ModelAndView("login");
			mav.addObject("message", "The user doesn't exist !");
			return mav;			
		}else if(BCrypt.checkpw(password, u.getPassword())){
			if(u.getAccount_blocked() == 1){
				return new ModelAndView("redirect/home", "message", "your accout has been blocked for many reasons.");
			}else{
				request.getSession().setAttribute("admin",u.getAdmin());
				request.getSession().setAttribute("login",u.getEmail());
				request.getSession().setAttribute("first_name",u.getFirstName());
				request.getSession().setAttribute("last_name",u.getLastName());
				return new ModelAndView("redirect:/home");
			}			
		}else{
			mav = new ModelAndView("login");
			mav.addObject("message", "Credencials failure, please try again.");
			return mav;
		}				
	}
}
