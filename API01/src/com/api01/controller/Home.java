package com.api01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Home {	

	@RequestMapping(value={"", "/", "/home"})
	public ModelAndView showMessage(HttpServletRequest request) {
		String message = (String)request.getParameter("message");		
		if(message != null)
			return new ModelAndView("home","message", message);
		else
			return new ModelAndView("home");
	}
}

