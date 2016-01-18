package com.api01.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.dialect.Ingres10Dialect;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.api01.bean.Comment;
import com.api01.bean.Idea;
import com.api01.bean.Idea.EnumState;
import com.api01.bean.UpVote;
import com.api01.bean.User;
import com.api01.dao.CommentDaoImpl;
import com.api01.dao.IdeaDaoImpl;
import com.api01.dao.UpVoteDaoImpl;
import com.api01.dao.UserDaoImpl;

@Controller
public class Home {

	@Autowired
	UserDaoImpl userdaoimpl;

	@Autowired
	IdeaDaoImpl ideadaoimpl;

	@Autowired
	CommentDaoImpl commentdaoimpl;

	@Autowired
	UpVoteDaoImpl upvotedaoimpl;

	@RequestMapping(value = { "", "/", "/home" })
	public ModelAndView showMessage(HttpServletRequest request) {

		User u1 = new User("password", "email", "firstName", "lastName", "adress", 2, new Date(), 1, 0);
		User u2 = new User("password", "mail", "firstName", "lastName", "adress", 3, new Date(), 0, 0);
		Idea i1 = new Idea("description", "application", "targeted_market", 2.3, EnumState.proposal, "long_summary",
				u1);
		Idea i2 = new Idea("description", "application", "targeted_market", 2.3, EnumState.proposal, "long_summary",
				u2);

		userdaoimpl.addUser(u1);
		userdaoimpl.addUser(u2);
		ideadaoimpl.addIdea(i1);
		ideadaoimpl.addIdea(i2);

		UpVote up1 = new UpVote(1, u1, i1);
		UpVote up2 = new UpVote(-1, u1, i2);
		UpVote up3 = new UpVote(1, u2, i1);
		UpVote up4 = new UpVote(-1, u2, i2);

		upvotedaoimpl.addUpVote(up1);
		upvotedaoimpl.addUpVote(up2);
		upvotedaoimpl.addUpVote(up3);
		upvotedaoimpl.addUpVote(up4);

		Comment c1 = new Comment("text", u1, i1);
		Comment c2 = new Comment("text", u1, i1);
		Comment c3 = new Comment("text", u1, i2);
		Comment c4 = new Comment("text", u2, i1);

		commentdaoimpl.addComment(c1);
		commentdaoimpl.addComment(c2);
		commentdaoimpl.addComment(c3);
		commentdaoimpl.addComment(c4);

		System.out.println(ideadaoimpl.getLikes(i1));
		System.out.println(ideadaoimpl.getDislikes(i2));
		System.out.println(upvotedaoimpl.getUpVotesByUserByIdea(u1, i1).get(0).getId());

		System.out.println(commentdaoimpl.getComments());

		String message = (String) request.getParameter("message");
		if (message != null)
			return new ModelAndView("home", "message", message);
		else
			return new ModelAndView("home");
	}
}
