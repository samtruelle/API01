package com.api01.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.api01.dao.UserDaoImpl;
import com.api01.dao.IdeaDaoImpl;
import com.api01.bean.Idea;
import com.api01.bean.User;

@Controller
public class Admin {
	
	@Autowired
	UserDaoImpl	userdaoimpl;
	@Autowired
	IdeaDaoImpl	ideadaoimpl;
	
	
	@RequestMapping("/admin")	
	public ModelAndView admin(){
		return new ModelAndView("admin");
	}
	
	@RequestMapping("/adminUsers")
	public ModelAndView showUsers() {
		userdaoimpl.getUsers();
		return new ModelAndView("adminUsers", "users", userdaoimpl.getUsers());
	}
	
	@RequestMapping("/adminDeleteUser")
	public ModelAndView deleteUser(HttpServletRequest request, @RequestParam("userId") String userId){
		User user = userdaoimpl.getUserById(Integer.parseInt(userId));
		if(user != null){
			userdaoimpl.removerUser(user);			
			return new ModelAndView("redirect:/adminUsers	");
		}else{			
			return new ModelAndView("redirect:/home", "message", "an error occured");
		}
	}
	
	@RequestMapping(value = "/adminCreateUser",method = RequestMethod.GET)
	public ModelAndView createUser(Model model) {
		model.addAttribute("user", new User());
		return new ModelAndView("adminCreateUser", "command", new User());
	}
	
	@RequestMapping(value = "/adminCreateUser",method = RequestMethod.POST)
	public ModelAndView checkCreationUser(HttpServletRequest request,@ModelAttribute("command")User user) {
		ModelAndView mav;
		if(userdaoimpl.getUserByMail(user.getEmail()) != null){
			mav = new ModelAndView("adminCreateUser", "command", user);
			mav.addObject("message", "A user allready exists with the email given !");
			return  mav;
		}else{		
			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
			java.util.Date d = new java.util.Date();
			user.setCreationDate(new java.sql.Date(d.getTime()));
			user.setAdmin(user.getAdmin());
			user.setAccount_blocked(user.getAccount_blocked());
			userdaoimpl.addUser(user);
			return new ModelAndView("redirect:/adminUsers");		
		}
	}
	
	@RequestMapping(value = "/adminEditUser",method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request, @RequestParam("userId") String userId, Model model) {
		User user = userdaoimpl.getUserById(Integer.parseInt(userId));
		if(user == null){
			return new ModelAndView("redirect:/adminUsers","message","The user you want to edit doesn't exist");
		}else{
			model.addAttribute("user", user);
			return new ModelAndView("adminEditUser", "command", user);
		}		
	}
	
	@RequestMapping(value = "/adminEditUser",method = RequestMethod.POST)
	public ModelAndView checkEditUser(HttpServletRequest request,@ModelAttribute("command")User user) {		
		if(userdaoimpl.updateUser(user) == 0){
			return new ModelAndView("redirect:/home","message","An error occured, user not created");
		}
		else{		
			return new ModelAndView("redirect:/adminUsers", "message", "User created");	
		}	
	}
	
	@RequestMapping("/adminIdeas")
	public ModelAndView showIdeas() {
		userdaoimpl.getUsers();
		return new ModelAndView("adminIdeas", "ideas", ideadaoimpl.getIdeas());
	}
	
	@RequestMapping("/adminDeleteIdea")
	public ModelAndView deleteIdea(HttpServletRequest request, @RequestParam("ideaId") String ideaId){
		Idea idea = ideadaoimpl.getIdeaById(Integer.parseInt(ideaId));
		if(idea != null){
			ideadaoimpl.removerIdea(idea);
			return new ModelAndView("redirect:/adminIdeas");
		}else{			
			return new ModelAndView("redirect:/home", "message", "an error occured");
		}
	}
	
	@RequestMapping(value = "/adminCreateIdea",method = RequestMethod.GET)
	public ModelAndView createIdea(Model model) {
		model.addAttribute("idea", new Idea());
		return new ModelAndView("adminCreateIdea", "command", new Idea());
	}
	
	@RequestMapping(value = "/adminCreateIdea",method = RequestMethod.POST)
	public ModelAndView checkCreationIdea(HttpServletRequest request,@ModelAttribute("command")Idea idea) {
		ModelAndView mav;
		if(ideadaoimpl.getIdeaById(idea.getIdea_id()) != null){
			mav = new ModelAndView("adminCreateIdea", "command", idea);
			mav.addObject("message", "An idea allready exists with the email given !");
			return  mav;
		}else{			
			User user = userdaoimpl.getUserByMail((String)request.getSession().getAttribute("login"));
			if(user == null){
				return new ModelAndView("redirect:/adminIdeas", "message", "An error occured");				
			}else{
				idea.setUser(user);
				idea.setFund(0);
				idea.setLong_summary("");
				idea.setState(Idea.EnumState.discussion);							
				if(ideadaoimpl.addIdea(idea) == 0){
					return new ModelAndView("redirect:/adminIdeas","message","An error occured, idea not created");
				}else{
					return new ModelAndView("redirect:/adminIdeas");
				}				
			}			
		}
	}
	
	@RequestMapping(value = "/adminEditIdea",method = RequestMethod.GET)
	public ModelAndView editIdea(HttpServletRequest request, @RequestParam("ideaId") String ideaId, Model model) {
		Idea idea = ideadaoimpl.getIdeaById(Integer.parseInt(ideaId));
		request.getSession().setAttribute("idea", idea);
		if(idea == null){
			return new ModelAndView("redirect:/adminIdeas","message","The idea you want to edit doesn't exist");
		}else{
			model.addAttribute("idea", idea);
			return new ModelAndView("adminEditIdea", "command", idea);
		}		
	}
	
	@RequestMapping(value = "/adminEditIdea",method = RequestMethod.POST)
	public ModelAndView checkEditUser(HttpServletRequest request,@ModelAttribute("command")Idea idea) {
		Idea ideaPersisted = (Idea)request.getSession().getAttribute("idea");
		request.setAttribute("idea", null);
		ideaPersisted.setApplication(idea.getApplication());
		ideaPersisted.setTargeted_market(idea.getTargeted_market());
		ideaPersisted.setDescription(idea.getDescription());	
		int i = ideadaoimpl.updateIdea(ideaPersisted);
		if(i == 0){
			return new ModelAndView("redirect:/home", "message","An error occured, idea not created");
		}
		else{		
			return new ModelAndView("redirect:/adminIdeas");	
		}	
	}
	
	
	@RequestMapping(value="/ajaxresult",method = RequestMethod.GET)
	public @ResponseBody
	String getResult(HttpServletRequest request){
		String q=request.getParameter("query");
		System.out.println(q);
		return "test";
	}
	
	
	@RequestMapping(value="/adminComments",method = RequestMethod.GET)
	public ModelAndView searchIdea(HttpServletRequest request) {
		String q=request.getParameter("query");
		System.out.println(request.getParameter("query"));
		ArrayList<Idea> ideas=ideadaoimpl.getIdeaTitle(q);
		System.out.println(q);
		System.out.println(ideas);
		
		return new ModelAndView("adminComments");
	}
}
