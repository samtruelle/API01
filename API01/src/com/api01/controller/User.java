package com.api01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.api01.bean.Idea;

@Controller
public class User {

	@RequestMapping(value="/userCreateIdea", method = RequestMethod.GET)	
	public ModelAndView admin(Model model) {
		model.addAttribute("idea", new Idea());
		return new ModelAndView("userCreateIdea", "command", new Idea());	
	}	
}
