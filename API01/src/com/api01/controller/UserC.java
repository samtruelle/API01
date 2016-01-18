package com.api01.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.api01.bean.Idea;
import com.api01.bean.User;
import com.api01.bean.UpVote;
import com.api01.dao.IdeaDaoImpl;
import com.api01.dao.UserDaoImpl;
import com.api01.dao.UpVoteDaoImpl;

@Controller
public class UserC {
	
	@Autowired
	IdeaDaoImpl ideadaoimpl;
	@Autowired
	UserDaoImpl	userdaoimpl;
	@Autowired
	UpVoteDaoImpl upvotedaoimpl;
	/*@Autowired
	CommentDaoImpl commentdaoimpl*/
	
	@RequestMapping(value="/userCreateIdea", method = RequestMethod.GET)	
	public ModelAndView userCreateIdea(Model model) {
		model.addAttribute("idea", new Idea());
		return new ModelAndView("userCreateIdea", "command", new Idea());	
	}
	
	@RequestMapping(value="/userCreateIdea", method = RequestMethod.POST)	
	public ModelAndView checkUserCreateIdea(HttpServletRequest request,@ModelAttribute("command")Idea idea) {
		ModelAndView mav;
		if(ideadaoimpl.getIdeaById(idea.getIdea_id()) != null){
			mav = new ModelAndView("adminCreateIdea", "command", idea);
			mav.addObject("message", "An idea allready exists with the email given !");
			return  mav;
		}else{			
			com.api01.bean.User user = userdaoimpl.getUserByMail((String)request.getSession().getAttribute("login"));
			if(user == null){
				return new ModelAndView("redirect:/home", "message", "An error occured");				
			}else{
				idea.setUser(user);
				idea.setFund(0);
				idea.setLong_summary("");
				idea.setState(Idea.EnumState.discussion);							
				if(ideadaoimpl.addIdea(idea) == 0){
					return new ModelAndView("redirect:/home","message","An error occured, idea not created");
				}else{
					return new ModelAndView("redirect:/userIdeas");
				}				
			}			
		}	
	}
	
	@RequestMapping(value = "/userEditIdea",method = RequestMethod.GET)
	public ModelAndView editIdea(HttpServletRequest request, @RequestParam("ideaId") String ideaId, Model model) {
		Idea idea = ideadaoimpl.getIdeaById(Integer.parseInt(ideaId));
		request.getSession().setAttribute("idea", idea);
		if(idea == null){
			return new ModelAndView("redirect:/userIdeas","message","The idea you want to edit doesn't exist");
		}else{
			model.addAttribute("idea", idea);
			return new ModelAndView("userEditIdea", "command", idea);
		}		
	}
	
	@RequestMapping(value = "/userEditIdea",method = RequestMethod.POST)
	public ModelAndView checkEditUser(HttpServletRequest request,@ModelAttribute("command")Idea idea) {
		Idea ideaPersisted = (Idea)request.getSession().getAttribute("idea");
		request.setAttribute("idea", null);
		ideaPersisted.setApplication(idea.getApplication());
		ideaPersisted.setTargeted_market(idea.getTargeted_market());
		ideaPersisted.setDescription(idea.getDescription());
		ideaPersisted.setTitle(idea.getTitle());
		int i = ideadaoimpl.updateIdea(ideaPersisted);
		if(i == 0){
			return new ModelAndView("redirect:/home", "message","An error occured, idea not created");
		}
		else{		
			return new ModelAndView("redirect:/userIdeas");	
		}	
	}
	
	@RequestMapping("/userIdeas")
	public ModelAndView userIdeas(HttpServletRequest request){			
		List<Idea> ideas = ideadaoimpl.getIdeaByUser(userdaoimpl.getUserByMail((String)request.getSession().getAttribute("login")));
		if(ideas == null){
			return new ModelAndView("redirect:/home", "message","An error occured");
		}else{
			return new ModelAndView("userIdeas", "ideas",ideas );
		}
	}
	
	@RequestMapping("/userDeleteIdea")
	public ModelAndView deleteIdea(HttpServletRequest request, @RequestParam("ideaId") String ideaId){
		Idea idea = ideadaoimpl.getIdeaById(Integer.parseInt(ideaId));
		if(idea != null){
			User user = idea.getUser();
			if(user.getEmail() == request.getSession().getAttribute("login")){
				ideadaoimpl.removerIdea(idea);
				return new ModelAndView("redirect:/userIdeas");
			}else
				return new ModelAndView("redirect:/home", "message", "You are not allowed to delete this idea");			
		}else{			
			return new ModelAndView("redirect:/home", "message", "an error occured");
		}
	}
	
	@RequestMapping("/userViewIdea")
	public ModelAndView viewIdea(HttpServletRequest request, @RequestParam("ideaId") String ideaId){		
		Idea idea = ideadaoimpl.getIdeaById(Integer.parseInt(ideaId));
		System.out.println(idea.getApplication());
		ModelAndView mav;
		if(idea != null){
			 switch (idea.getState()) {
		         case discussion:
		        	 System.out.println("discussion");		        	 
		        	 mav = new ModelAndView("userViewIdeaDiscussion", "idea", idea);
		        	 mav.addObject("likes", "");
		        	 mav.addObject("dislikes", "");
		        	 mav.addObject("comments", "");
		        	 /*mav.addObject("likes", ideadaoimpl.getLikes(idea));
		        	 mav.addObject("dislikes", ideadaoimpl.getDislikes(idea));
		        	 mav.addObject("comments", commentdaoimpl.getCommentByIdea(idea));*/
		        	 return mav;
		         case redaction:
		        	 System.out.println("redaction");
		        	 mav = new ModelAndView("userViewIdeaRedaction", "idea", idea);	
		        	 return mav;
		         case evaluation:
		        	 System.out.println("evalu");
		        	 mav = new ModelAndView("userViewIdeaEvaluation", "idea", idea);
		        	 return mav;
		         case fund:
		        	 System.out.println("fund");
		        	 mav = new ModelAndView("userViewIdeaFund", "idea", idea);
		        	 return mav;
		         default:
		        	 return new ModelAndView("redirect:/home", "message", "An error occured");			 
			 }
		}
	 	else			
			return new ModelAndView("redirect:/home", "message", "an error occured");			
	}
	
	@RequestMapping("/userLikeIdea")
	public ModelAndView userLikedIdea(HttpServletRequest request, @RequestParam("ideaId") String ideaId , @RequestParam("value") String value){
		Idea idea = ideadaoimpl.getIdeaById(Integer.parseInt(ideaId));
		User user = userdaoimpl.getUserByMail((String)request.getSession().getAttribute("login"));
		Integer Value = Integer.parseInt(value);
		if(idea == null || idea.getState() != Idea.EnumState.discussion)
			return new ModelAndView("redirect:/home", "message", "An error occured, objects missing");		
		else{
			if(idea.getUser().getEmail() == user.getEmail()){
				return new ModelAndView("redirect:/home", "message", "You can't evaluate your own idea");
			}else{
				/*if(upvotedaoimpl.getUpVoteByUserIdea()){
					return new ModelAndView("redirect:/home","message","You can't vote two times for an idea");
				}else{*/					
					if(upvotedaoimpl.addUpVote(new UpVote(Value, user, idea)) == 0){
						return new ModelAndView("redirect:/home", "message", "An error occured prout");
					}else{
						return new ModelAndView("redirect:/userViewIdea", "ideaId", idea.getIdea_id());
					}
				//}				
			}
		}
	}
}
