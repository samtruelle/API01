package com.api01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Home {
	
	String message = "Welcome to your 1st Maven Spring project !";

	@RequestMapping(value={"", "/", "/home"})
	public ModelAndView showMessage() {		
		return new ModelAndView("home");
	}
}

