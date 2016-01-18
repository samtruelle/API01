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
@RequestMapping("/logout")
public class Logout {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showMessage(HttpServletRequest request) {
		request.getSession().removeAttribute("first_name");
		request.getSession().removeAttribute("last_name");
		request.getSession().removeAttribute("admin");
		request.getSession().removeAttribute("email");		
		return new ModelAndView("redirect:/home");
	}
}
