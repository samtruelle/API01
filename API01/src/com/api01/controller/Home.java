package com.api01.controller;

import java.util.Date;

import com.api01.dao.DetailedScoreDaoImpl;
import com.api01.dao.DonationDaoImpl;
import com.api01.dao.IdeaDaoImpl;
import com.api01.dao.UpVoteDaoImpl;
import com.api01.dao.UserDaoImpl;
import com.api01.bean.DetailedScore;
import com.api01.bean.Donation;
import com.api01.bean.Idea;
import com.api01.bean.Idea.EnumState;
import com.api01.bean.UpVote;
import com.api01.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;  


@Controller
public class Home {
	@Autowired
	UserDaoImpl userdaoimpl;
	@Autowired
	IdeaDaoImpl ideaDaoImpl;
	@Autowired
	UpVoteDaoImpl upVoteDaoImpl;
	@Autowired
	DetailedScoreDaoImpl detailedScoreDaoImpl;
	@Autowired
	DonationDaoImpl donationDaoImpl;
	
	String message = "Welcome to your 1st Maven Spring project !";

	@RequestMapping("/hello")
	public ModelAndView showMessage() {		
		System.out.println("from controller");
		
		User u1 = new User("password", "email", "firstName", "lastName", "adress", 6, new Date(), 1, 0);
		User u2 = new User("password", "email2", "firstName", "lastName", "adress", 5, new Date(),0, 0);
		Idea i1 = new Idea("description", "application", "targeted_market", 120.0, EnumState.proposal, "long_summary");
		Idea i2 = new Idea("description", "application", "targeted_market", 100.0, EnumState.evaluation, "long_summary");
		Idea i3 = new Idea("description", "application", "targeted_market", 150.0, EnumState.discussion, "long_summary");
		
		userdaoimpl.addUser(u1);
		userdaoimpl.addUser(u2);
		ideaDaoImpl.addIdea(i1);
		ideaDaoImpl.addIdea(i2);
		ideaDaoImpl.addIdea(i3);
		
		UpVote uv1 = new UpVote(1, u1, i1);
		UpVote uv2 = new UpVote(1, u2, i2);
		
		upVoteDaoImpl.addUpVote(uv1);
		upVoteDaoImpl.addUpVote(uv2);
		
		System.out.println(upVoteDaoImpl.getUpVotesByIdea(i1).get(0).getvalue());
		System.out.println(upVoteDaoImpl.getUpVotesByUser(u2).get(0).getvalue());
		
		DetailedScore ds1 = new DetailedScore(3, 4, 5, i1,u1);
		DetailedScore ds2 = new DetailedScore(3, 4, 5, i2,u1);
		DetailedScore ds3 = new DetailedScore(4, 5, 2, i2,u2);
		
		detailedScoreDaoImpl.addDetailedScore(ds1);
		detailedScoreDaoImpl.addDetailedScore(ds2);
		detailedScoreDaoImpl.addDetailedScore(ds3);
		
		System.out.println(detailedScoreDaoImpl.getDetailedScoreByIdea(i2));
		System.out.println(detailedScoreDaoImpl.getDetailedScoreByUser(u1));
		System.out.println(detailedScoreDaoImpl.getDetailedScores());
		
		Donation do1 = new Donation(2999.3,u1,i1);
		Donation do2 = new Donation(2999.3,u2,i2);
		
		donationDaoImpl.addDonation(do1);
		donationDaoImpl.addDonation(do2);
		
		System.out.println(donationDaoImpl.getDonationByIdea(i2));
		System.out.println(donationDaoImpl.getDonationByUser(u1));
		
		donationDaoImpl.removeDonation(do1);
		
		System.out.println(detailedScoreDaoImpl.getDetailedScores());
		
		return new ModelAndView("hello", "message", message);
	}
}

